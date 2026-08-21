#!/bin/bash
#
# Usage: cd meta-ros
#        scripts/check-rosdistro-tags.sh [-d DAYS] [-r ROS_DISTRO ...]
#            or
#        scripts/check-rosdistro-tags.sh --version
#
# Checks https://github.com/ros/rosdistro for release tags (format
# "<ROS_DISTRO>/<YYYY-MM-DD>") that are newer than what this repo has
# already synced, and reports which ROS distros are due for a
# generate_recipes.yml run. Intended to back a scheduled trigger for that
# workflow (see .github/workflows/check-rosdistro-tags.yml) so recipe
# regeneration no longer depends on someone remembering to click
# "Run workflow" -- but this script only detects and reports; it does not
# dispatch anything itself.
#
# For each distro this compares rosdistro's newest "<distro>/<date>" tag
# against the release date already recorded in this repo, in the first
# line of meta-ros?-<distro>/files/<distro>/generated/cache.yaml (written
# by ros-generate-cache.sh -- see that script for the exact format). A
# distro is reported as due when its newest tag is both newer than the
# recorded date AND no older than DAYS days (default 30). The DAYS bound
# exists to keep this a "notice new releases promptly" check rather than
# a "go back and regenerate every release we ever missed" check -- if a
# gap larger than DAYS ever opens up (e.g. this check was broken for a
# while), fall back to a manual generate_recipes.yml dispatch for that
# distro rather than widening the window indefinitely.
#
# Distros whose newest tag is a non-date value (e.g. "final" for an EOL
# distro like noetic) are only flagged if that value itself changed, since
# there's no date to compare against the DAYS window.
#
# Copyright (c) 2026 Wind River Systems, Inc.

readonly SCRIPT_NAME="check-rosdistro-tags"
readonly SCRIPT_VERSION="1.0.0"
readonly ROSDISTRO_URL="https://github.com/ros/rosdistro.git"
readonly DEFAULT_DAYS=30
readonly DEFAULT_DISTROS="noetic humble jazzy kilted lyrical rolling"

usage() {
    echo "Usage: cd meta-ros"
    echo "       scripts/$SCRIPT_NAME.sh [-d DAYS] [-r ROS_DISTRO ...]"
    echo "               or"
    echo "       scripts/$SCRIPT_NAME.sh --version"
    echo ""
    echo "  -d DAYS        only consider tags at most DAYS days old (default: $DEFAULT_DAYS)"
    echo "  -r ROS_DISTRO  check only this distro; may be repeated (default: $DEFAULT_DISTROS)"
    exit 1
}

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

days=$DEFAULT_DAYS
distros=""
while getopts "d:r:" opt; do
    case $opt in
        d) days="$OPTARG" ;;
        r) distros="$distros $OPTARG" ;;
        *) usage ;;
    esac
done
[ -z "$distros" ] && distros="$DEFAULT_DISTROS"

case $days in
    [1-9]|[1-9][0-9]|[1-9][0-9][0-9]) : OK ;;
    *) echo "ABORT: -d DAYS must be a positive integer: '$days'"; exit 1 ;;
esac

today_epoch=$(date -u +%s)
due_distros=""

printf '%-8s %-14s %-14s %-9s %s\n' "DISTRO" "RECORDED" "NEWEST_TAG" "AGE_DAYS" "ACTION"

for distro in $distros; do
    layer=$(ls -d meta-ros?-"$distro" 2>/dev/null | head -n1)
    if [ -z "$layer" ] || [ ! -d "$layer" ]; then
        printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "-" "-" "-" "SKIP: no meta-ros?-$distro layer found"
        continue
    fi

    cache_file="$layer/files/$distro/generated/cache.yaml"
    if [ ! -f "$cache_file" ]; then
        printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "-" "-" "-" "SKIP: no $cache_file (never synced?)"
        continue
    fi
    recorded=$(head -n1 "$cache_file" | awk '{print $3}')

    # refs/tags/<distro>/<date> and refs/tags/<distro>/<date>^{} (the
    # peeled commit of an annotated tag) both show up here; strip the
    # peel marker and de-duplicate before taking the newest.
    newest=$(git ls-remote --tags "$ROSDISTRO_URL" "refs/tags/$distro/*" 2>/dev/null \
        | awk -F/ '{print $NF}' | sed 's/\^{}$//' | sort -u | tail -n1)
    if [ -z "$newest" ]; then
        printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "-" "-" "SKIP: no tags found upstream (network/API issue?)"
        continue
    fi

    if [ "$newest" = "$recorded" ]; then
        printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "$newest" "-" "up to date"
        continue
    fi

    case $newest in
        [2-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9])
            newest_epoch=$(date -u -d "$newest" +%s 2>/dev/null)
            if [ -z "$newest_epoch" ]; then
                printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "$newest" "-" "SKIP: could not parse tag date"
                continue
            fi
            age_days=$(( (today_epoch - newest_epoch) / 86400 ))
            if [ "$age_days" -lt 0 ]; then
                printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "$newest" "$age_days" "SKIP: tag date is in the future?"
                continue
            fi
            if [ "$age_days" -gt "$days" ]; then
                printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "$newest" "$age_days" "SKIP: newer tag exists but is older than ${days}d window (manual dispatch recommended)"
                continue
            fi
            printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "$newest" "$age_days" "DUE"
            due_distros="$due_distros $distro"
            ;;
        *)
            # Non-date tag value (e.g. "final", "pre-release") that
            # differs from what's recorded: flag for a human to look at
            # rather than guessing an age.
            printf '%-8s %-14s %-14s %-9s %s\n' "$distro" "$recorded" "$newest" "-" "DUE: non-date tag changed, review manually"
            due_distros="$due_distros $distro"
            ;;
    esac
done

due_distros=$(echo "$due_distros" | xargs)

if [ -n "$GITHUB_OUTPUT" ]; then
    json="[]"
    if [ -n "$due_distros" ]; then
        json=$(printf '%s\n' $due_distros | awk 'BEGIN{printf "["} {printf "%s\"%s\"", (NR>1?",":""), $0} END{printf "]"}')
    fi
    echo "due_distros=$json" >> "$GITHUB_OUTPUT"
fi

echo ""
if [ -n "$due_distros" ]; then
    echo "Due for generate_recipes.yml:$due_distros"
else
    echo "Nothing due."
fi
