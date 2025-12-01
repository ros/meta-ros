# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "An rcl logger implementation that doesn't do anything with log messages."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Nick Burek <amazon-b9-ros@amazon.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rcl_logging"
ROS_BPN = "rcl_logging_noop"

ROS_BUILD_DEPENDS = "\
    rcl-logging-interface\
    rcutils\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
    python3-empy-native\
"

ROS_EXPORT_DEPENDS = "\
    rcl-logging-interface\
    rcutils\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rcl-logging-interface\
    rcutils\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    ament-cmake-gtest\
    ament-lint-common\
    ament-lint-auto\
    launch-testing\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/rcl_logging.git;${ROS_BRANCH};protocol=https"
SRCREV = "727920c2592be6deb6983f0fe1b57cbc929cbb70"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/rcl_logging_noop"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
