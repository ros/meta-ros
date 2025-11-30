# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "topic_tools_interfaces contains messages and services for topic_tools"
AUTHOR = "Emerson Knapp <me@emersonknapp.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "topic_tools_interfaces"
ROS_BPN = "topic_tools_interfaces"

ROS_BUILD_DEPENDS = "\
    rosidl-default-generators\
    builtin-interfaces\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    builtin-interfaces\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime\
    builtin-interfaces\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/topic_tools_interfaces"
SRC_URI = "git://github.com/ros2-gbp/topic_tools-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "667e5543b19d8d575326e16bafd9be674cbc5442"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
