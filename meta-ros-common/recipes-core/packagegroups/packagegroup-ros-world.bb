# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "All non-test packages for the target from files/${ROS_DISTRO}/cache.yaml"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} += "\
    ${@ 'packagegroup-ros-world-melodic' if 'ros1-melodic-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-crystal' if 'ros2-crystal-layer' in BBFILE_COLLECTIONS.split() else '' } \
    ${@ 'packagegroup-ros-world-dashing' if 'ros2-dashing-layer' in BBFILE_COLLECTIONS.split() else '' } \
"
