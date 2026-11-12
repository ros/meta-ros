# Advanced Usage

- [Introduction](#introduction)
- [Combining configurations](#combining-configurations)
- [Customizing a build](#customizing-a-build)
- [Everyday kas commands](#everyday-kas-commands)
- [Using kas in CI](#using-kas-in-ci)

## Introduction

This guide covers customizing builds beyond the ready-made `oeros-*` configs.
It assumes you have completed the [getting started guide](BUILD.md).

## Combining configurations

kas merges any number of files given on one command line, separated by `:`.
Later files override earlier ones. Use this to add a fragment to a ready-made
config:

Jazzy on a Raspberry Pi 5 with systemd and GUI support:
```bash
kas build meta-ros/kas/oeros-wrynose-jazzy-raspberrypi5.yml:meta-ros/kas/systemd.yml:meta-ros/kas/visualization.yml
```

Keep the desktop responsive and stop before the disk fills:
```bash
kas build meta-ros/kas/oeros-wrynose-lyrical-qemux86-64.yml:meta-ros/kas/limit-pressure.yml:meta-ros/kas/diskmon.yml
```

kas requires every file on one command line to be in the same git checkout, so
put your own fragments inside the meta-ros checkout (an untracked file in
`meta-ros/kas/` works), or write a top-level file that includes ours (see
below).

To assemble a combination that has no `oeros-*` file, include the fragments
yourself:

```yaml
# meta-ros/kas/my-wrynose-jazzy-qemuarm64.yml
header:
  version: 14
  includes:
    - kas/yocto/wrynose.yml
    - kas/ros2/jazzy.yml
    - kas/machine/qemuarm64.yml
    - kas/common.yml
    - kas/layer/qt5.yml
```

Copy the Qt layer choice and any `repos:` branch overrides from the nearest
`oeros-*` file for the same release and distro, since those are the tested
combinations.

## Customizing a build

**Build a different image or recipe.** `--target` overrides the config's
target, and `-c` runs a single task:

```sh
kas build --target ros-image-turtlebot3-core meta-ros/kas/oeros-wrynose-jazzy-raspberrypi4-64.yml
kas build --target rclcpp -c compile meta-ros/kas/oeros-wrynose-lyrical-qemux86-64.yml
```

**Add `local.conf` settings.** Put them in a fragment and append it with `:`:

```yaml
# meta-ros/kas/local.yml  (untracked)
header:
  version: 14

local_conf_header:
  mine: |
    IMAGE_INSTALL:append = " ros-demos"
    EXTRA_IMAGE_FEATURES += "ssh-server-openssh"
```

**Share downloads and sstate between builds.** Set `DL_DIR` and `SSTATE_DIR`
in your environment (see [Set up](BUILD.md#set-up)); kas passes them to bitbake.

**Build a different meta-ros branch or fork.** Override the `ros` repo (use
`spaceros` for Space ROS configs):

```yaml
# meta-ros/kas/my-meta-ros.yml  (untracked)
header:
  version: 14

repos:
  ros:
    url: "https://github.com/<you>/meta-ros.git"   # or file:///path/to/meta-ros
    branch: "my-feature"
```

```sh
kas build --update meta-ros/kas/oeros-wrynose-lyrical-qemux86-64.yml:meta-ros/kas/my-meta-ros.yml
```

You can also work directly in `layers/meta-ros`, which is an ordinary git
checkout. Commit or stash there before running kas with `--update`.

**Pin every layer.** Only the Yocto core layers are pinned to commits; the rest
follow branches. To record exact revisions for a reproducible build:

```sh
kas lock meta-ros/kas/oeros-wrynose-lyrical-qemux86-64.yml
```

This writes a `.lock.yml` file next to the config that kas applies
automatically on later runs.

## Everyday kas commands

| Task | Command |
| --- | --- |
| Clone or update layers only | `kas checkout [--update] <config>` |
| Build | `kas build <config>` |
| Pull new commits on branch-tracked layers, then build | `kas build --update <config>` |
| Open a shell with the bitbake environment | `kas shell <config>` |
| Run one bitbake command | `kas shell <config> -c "bitbake -c cleansstate <recipe>"` |
| Print the fully merged config | `kas dump <config>` |
| Write a lock file | `kas lock <config>` |

## Using kas in CI

The project's own pipeline is [`.gitlab-ci.yml`](../.gitlab-ci.yml). It runs
manually, in a CROPS-based container, and picks the config from three
variables:

```
kas build --update oeros-${OE_RELEASE_SERIES}-${ROS_DISTRO}-${MACHINE}.yml[:extra fragments]
```

| Variable | Purpose |
| --- | --- |
| `OE_RELEASE_SERIES`, `ROS_DISTRO`, `MACHINE` | Choose the `oeros-*` config. |
| `BITBAKE_TARGET`, `BITBAKE_TASK` | Passed to kas as `--target` and `-c`. |
| `EXTRA_KAS_YAML` | Extra fragments appended with `:` (for example `buildci.yml`). |
| `EXTRA_BITBAKE_ARGS` | Passed to bitbake after `--`. |
| `META_ROS_GIT`, `META_ROS_BRANCH` | Build a meta-ros fork or branch; CI writes a `custom-meta-ros.yml` override like the one above. |
| `ENABLE_AWS_SUPPORT` | Adds `awsci.yml` (the project's S3 mirrors). |
| `KAS_WORK_DIR`, `KAS_REPO_REF_DIR`, `DL_DIR`, `SSTATE_DIR` | Put downloads, sstate and git references on persistent storage. |

The job keeps `local.conf`, buildstats, cooker logs and error reports as
artifacts for a week.

To run the same build in your own CI, the points that matter are:

- Use `kas-container` or a CROPS image so the host does not matter. The example
  below installs kas on the runner instead, which needs the Yocto host packages.
- Keep `DL_DIR`, `SSTATE_DIR` and `KAS_REPO_REF_DIR` on persistent storage
  shared between jobs. Without them every job is a full multi-hour build.
- Use `--update` so branch-tracked layers are current, or commit lock files
  (`kas lock`) if you need identical inputs every run.
- Append `buildci.yml` for buildhistory and buildstats.
- Hosted runners with small disks will not fit a ROS image build. Use a
  self-hosted runner with the resources listed under
  [Prerequisites](BUILD.md#prerequisites).

A minimal GitHub Actions job on a self-hosted runner looks like this:

```yaml
jobs:
  build:
    runs-on: self-hosted
    env:
      DL_DIR: /srv/yocto/downloads
      SSTATE_DIR: /srv/yocto/sstate
      KAS_REPO_REF_DIR: /srv/yocto/git
    steps:
      - uses: actions/checkout@v4
        with:
          repository: ros/meta-ros
          ref: build
          path: meta-ros
      - run: pip install kas
      - run: kas build --update meta-ros/kas/oeros-wrynose-lyrical-qemux86-64.yml:meta-ros/kas/buildci.yml
```
