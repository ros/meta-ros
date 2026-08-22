#!/usr/bin/env python3
#
# Merge fresh generate-skip-groups.py output into a
# packagegroup-ros-world-<distro>.bb file, updating only the auto-generated
# RDEPENDS:${PN}:remove / ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_*
# pairs. Matches by skip-group name (the first bb.utils.contains() argument)
# rather than blindly replacing the whole block, so that:
#
#   - a skip-group name present in both old and new output keeps its position
#     and any hand-written comment immediately above it (only the dependent
#     package list itself is refreshed);
#   - a name only in the old file (now resolved, no longer needed) is
#     removed, comment and all;
#   - a name only in the new output (newly unbuildable) is appended at the
#     end of the generated section, with no comment (nothing to preserve).
#
# Every other line in the file -- including hand-curated single-line
# RDEPENDS:${PN}:remove = "pkgname" entries with their own explanatory
# comments, and the separate ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_*
# mechanism -- is left untouched.
#
# Usage: update-skip-groups.py <packagegroup-file> <new-skip-groups-output-file>

import re
import sys

RDEPENDS_PREFIX = "RDEPENDS:${PN}:remove = \"${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', '"
DEPENDING_ON_PREFIX = "ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_"
NAME_RE = re.compile(r"^RDEPENDS:\$\{PN\}:remove = \"\$\{@bb\.utils\.contains\('ROS_WORLD_SKIP_GROUPS', '([^']+)',")


def usage():
    print("update-skip-groups.py <packagegroup-file> <new-skip-groups-output-file>")
    sys.exit(1)


def parse_blocks(lines):
    """Return an ordered list of (name, comment_lines, block_lines, start_index)
    for every auto-generated skip-group pair found in lines, plus the index
    range each block (including any immediately-preceding comment) occupies."""
    blocks = []
    i = 0
    while i < len(lines):
        line = lines[i]
        if line.startswith(RDEPENDS_PREFIX):
            m = NAME_RE.match(line)
            name = m.group(1) if m else None

            # Walk backwards over a contiguous run of comment lines
            # immediately above this RDEPENDS line (no blank line gap).
            comment_start = i
            j = i - 1
            while j >= 0 and lines[j].startswith("#"):
                comment_start = j
                j -= 1

            block_start = i
            block_end = i + 1  # exclusive
            if block_end < len(lines) and lines[block_end].startswith(DEPENDING_ON_PREFIX):
                block_end += 1
                while block_end < len(lines) and lines[block_end - 1].rstrip("\n").endswith("\\"):
                    block_end += 1

            blocks.append({
                "name": name,
                "comment_start": comment_start,
                "block_start": block_start,
                "block_end": block_end,
            })
            i = block_end
            continue
        i += 1
    return blocks


def parse_new_output(lines):
    """Return {name: block_lines} for the fresh generate-skip-groups.py output."""
    result = {}
    i = 0
    while i < len(lines):
        line = lines[i]
        if line.startswith(RDEPENDS_PREFIX):
            m = NAME_RE.match(line)
            name = m.group(1) if m else None
            start = i
            end = i + 1
            if end < len(lines) and lines[end].startswith(DEPENDING_ON_PREFIX):
                end += 1
                while end < len(lines) and lines[end - 1].rstrip("\n").endswith("\\"):
                    end += 1
            result[name] = lines[start:end]
            i = end
            continue
        i += 1
    return result


def main():
    if len(sys.argv) != 3:
        usage()

    packagegroup_path, new_output_path = sys.argv[1], sys.argv[2]

    with open(packagegroup_path) as f:
        lines = f.readlines()
    with open(new_output_path) as f:
        new_lines = f.readlines()
    if new_lines and not new_lines[-1].endswith("\n"):
        new_lines[-1] += "\n"

    old_blocks = parse_blocks(lines)
    if not old_blocks:
        print(f"ERROR: no existing auto-generated skip-group blocks found in {packagegroup_path}")
        sys.exit(1)

    new_by_name = parse_new_output(new_lines)
    old_names = [b["name"] for b in old_blocks]

    out = []
    cursor = 0
    first_block_start = old_blocks[0]["comment_start"]
    out.extend(lines[cursor:first_block_start])
    cursor = first_block_start

    for b in old_blocks:
        # Preserve anything between the previous block and this one's comment
        # (blank lines, unrelated content) verbatim.
        out.extend(lines[cursor:b["comment_start"]])
        if b["name"] in new_by_name:
            # Keep the comment (if any) and the RDEPENDS line, refresh the
            # dependent-package list.
            out.extend(lines[b["comment_start"]:b["block_start"] + 1])
            depending_on_lines = new_by_name[b["name"]][1:]
            out.extend(depending_on_lines)
        # else: resolved, drop the whole thing (comment included).
        cursor = b["block_end"]

    # Append any genuinely new skip-group names (not present before) right
    # after the last old block, with no fabricated comment.
    added_names = [n for n in new_by_name if n not in old_names]
    for name in added_names:
        out.extend(new_by_name[name])

    out.extend(lines[cursor:])

    with open(packagegroup_path, "w") as f:
        f.writelines(out)

    removed = [n for n in old_names if n not in new_by_name]
    if removed:
        print(f"Resolved (removed): {', '.join(removed)}")
    if added_names:
        print(f"Newly unbuildable (added): {', '.join(added_names)}")


if __name__ == "__main__":
    main()
