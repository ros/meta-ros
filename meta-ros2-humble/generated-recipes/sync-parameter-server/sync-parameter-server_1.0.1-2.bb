# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "TODO: Package description"
AUTHOR = "Tatsuro Sakaguchi <tatsuro.sakaguchi@g.softbank.co.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "sync_parameter_server"
ROS_BPN = "sync_parameter_server"

ROS_BUILD_DEPENDS = " \
    rcl-interfaces \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    rcl-interfaces \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rcl-interfaces \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/sync_parameter_server-release/archive/release/humble/sync_parameter_server/1.0.1-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/sync_parameter_server"
SRC_URI = "git://github.com/ros2-gbp/sync_parameter_server-release;${ROS_BRANCH};protocol=https"
SRCREV = "f1d7c5b3de4b01bc9e9c7352ef140d37bcc41d9a"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
