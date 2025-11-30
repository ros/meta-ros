# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Message/Service definitions specifically for the dwb_core"
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "dwb_msgs"
ROS_BPN = "dwb_msgs"

ROS_BUILD_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    nav-2d-msgs\
    std-msgs\
    nav-msgs\
    rosidl-default-runtime\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    nav-2d-msgs\
    std-msgs\
    nav-msgs\
    rosidl-default-runtime\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    nav-2d-msgs\
    std-msgs\
    nav-msgs\
    rosidl-default-runtime\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/dwb_msgs"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "d211d4926056c691c7a65b54fb08fa92464b26fd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
