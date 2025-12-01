# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Define a common interface between DDS implementations of ROS middleware."
AUTHOR = "Ivan Paunovic <ivanpauno@ekumenlabs.com>"
ROS_AUTHOR = "Brandon Ong <brandon@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmw_dds_common"
ROS_BPN = "rmw_dds_common"

ROS_BUILD_DEPENDS = "\
    rcutils\
    rcpputils\
    rmw\
    rosidl-runtime-c\
    rosidl-runtime-cpp\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    rosidl-default-generators-native\
"

ROS_EXPORT_DEPENDS = "\
    rcutils\
    rcpputils\
    rmw\
    rosidl-runtime-c\
    rosidl-runtime-cpp\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime\
    rcutils\
    rcpputils\
    rmw\
    rosidl-runtime-c\
    rosidl-runtime-cpp\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    ament-lint-auto\
    ament-lint-common\
    osrf-testing-tools-cpp\
    performance-test-fixture\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rmw_dds_common.git;${ROS_BRANCH};protocol=https"
SRCREV = "973ad5c8b60140dbdafe80eb8a192f1d913f94f6"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/rmw_dds_common"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
