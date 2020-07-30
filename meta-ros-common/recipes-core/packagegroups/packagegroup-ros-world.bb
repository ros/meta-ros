# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/${ROS_DISTRO}/cache.yaml"
LICENSE = "MIT"

# ROS_SUPERFLORE_GENERATED_ARCH_SPECIFIC_* variables used in packagegroup-ros-world-{melodic,dashing,eloquent} are MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} += "\
    ${@ 'packagegroup-ros-world-melodic' if 'ros1-melodic-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-noetic' if 'ros1-noetic-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-dashing' if 'ros2-dashing-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-eloquent' if 'ros2-eloquent-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-foxy' if 'ros2-foxy-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-rolling' if 'ros2-rolling-layer' in BBFILE_COLLECTIONS.split() else '' } \
"
