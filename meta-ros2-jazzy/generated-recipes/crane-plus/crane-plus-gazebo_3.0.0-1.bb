# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "CRANE+ V2 gazebo simulation package"
AUTHOR = "RT Corporation <shop@rt-net.jp>"
ROS_AUTHOR = "Shota Aoki <s.aoki@rt-net.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "crane_plus"
ROS_BPN = "crane_plus_gazebo"

ROS_BUILD_DEPENDS = " \
    controller-manager \
    crane-plus-description \
    crane-plus-moveit-config \
    gripper-controllers \
    robot-state-publisher \
    ros-gz \
    ros2-controllers \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    crane-plus-description \
    crane-plus-moveit-config \
    gripper-controllers \
    robot-state-publisher \
    ros-gz \
    ros2-controllers \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    crane-plus-description \
    crane-plus-moveit-config \
    gripper-controllers \
    robot-state-publisher \
    ros-gz \
    ros2-controllers \
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

# matches with: https://github.com/ros2-gbp/crane_plus-release/archive/release/jazzy/crane_plus_gazebo/3.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/crane_plus_gazebo"
SRC_URI = "git://github.com/ros2-gbp/crane_plus-release;${ROS_BRANCH};protocol=https"
SRCREV = "ccce12c5b37d3aacd342eb4d3b981f50d865f661"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
