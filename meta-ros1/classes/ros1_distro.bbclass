# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_distro

# Place metadata unique to ROS 1 distros here.
inherit ros_opt_prefix

# *.cmake files have hardcoded sysroot-s in them.
SSTATE_SCAN_FILES_append = " *.cmake"

DEPENDS_remove =  "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz', '', 'rviz', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz', '', 'rviz', d)}"
