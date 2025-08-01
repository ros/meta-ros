# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Planning components of MoveIt that use ROS"
AUTHOR = "Henning Kayser <henningkayser@picknik.ai>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit"
ROS_BPN = "moveit_ros_planning"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    libeigen \
    message-filters \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    pluginlib \
    rclcpp \
    rclcpp-action \
    srdfdom \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    eigen3-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    libeigen \
    message-filters \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    pluginlib \
    rclcpp \
    rclcpp-action \
    srdfdom \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    libeigen \
    message-filters \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    pluginlib \
    rclcpp \
    rclcpp-action \
    srdfdom \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-msgs \
    tf2-ros \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    moveit-configs-utils \
    moveit-resources-panda-moveit-config \
    ros-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/moveit2-release/archive/release/humble/moveit_ros_planning/2.5.9-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/moveit_ros_planning"
SRC_URI = "git://github.com/ros2-gbp/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "152f22ce10d1dae2280e403666bbdb599fb5f25e"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
