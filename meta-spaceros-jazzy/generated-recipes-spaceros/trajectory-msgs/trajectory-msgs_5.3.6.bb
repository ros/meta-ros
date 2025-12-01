# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A package containing some robot trajectory message definitions."
AUTHOR = "Tully Foote <tfoote@openrobotics.org>"
ROS_AUTHOR = "Geoffrey Biggs <geoff@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "common_interfaces"
ROS_BPN = "trajectory_msgs"

ROS_BUILD_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    std-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    rosidl-default-generators-native\
"

ROS_EXPORT_DEPENDS = "\
    builtin-interfaces\
    geometry-msgs\
    std-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime\
    builtin-interfaces\
    geometry-msgs\
    std-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=jazzy"
SRC_URI = "git://github.com/ros2/common_interfaces.git;${ROS_BRANCH};protocol=https"
SRCREV = "137e97dc5ec724b78cdbaa3b89927c3c29f81f02"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/trajectory_msgs"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
