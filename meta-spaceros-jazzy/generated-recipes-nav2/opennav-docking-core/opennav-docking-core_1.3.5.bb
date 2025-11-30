# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A set of headers for plugins core to the opennav docking framework"
AUTHOR = "Steve Macenski <steve@opennav.org>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "opennav_docking_core"
ROS_BPN = "opennav_docking_core"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclcpp-lifecycle\
    nav2-util\
    nav2-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclcpp-lifecycle\
    nav2-util\
    nav2-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    rclcpp-lifecycle\
    nav2-util\
    nav2-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
    ament-cmake-pytest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/opennav_docking_core"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "1e3220c2144d21eb7ee367757e0a7182cdc0b6f6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
