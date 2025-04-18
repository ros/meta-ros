# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Inverse Kinematics solver for MoveIt"
AUTHOR = "Tyler Weaver <maybe@tylerjw.dev>"
ROS_AUTHOR = "Tyler Weaver <maybe@tylerjw.dev>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "pick_ik"
ROS_BPN = "pick_ik"

ROS_BUILD_DEPENDS = " \
    fmt \
    generate-parameter-library \
    moveit-core \
    pluginlib \
    range-v3 \
    rclcpp \
    rsl \
    tf2-geometry-msgs \
    tf2-kdl \
    tl-expected \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = " \
    fmt \
    generate-parameter-library \
    moveit-core \
    pluginlib \
    range-v3 \
    rclcpp \
    rsl \
    tf2-geometry-msgs \
    tf2-kdl \
    tl-expected \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fmt \
    generate-parameter-library \
    moveit-core \
    pluginlib \
    range-v3 \
    rclcpp \
    rsl \
    tf2-geometry-msgs \
    tf2-kdl \
    tl-expected \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    moveit-resources-panda-moveit-config \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/pick_ik-release/archive/release/rolling/pick_ik/1.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/pick_ik"
SRC_URI = "git://github.com/ros2-gbp/pick_ik-release;${ROS_BRANCH};protocol=https"
SRCREV = "7d67049a406336c74fe490f95cc6c4d91d553efe"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
