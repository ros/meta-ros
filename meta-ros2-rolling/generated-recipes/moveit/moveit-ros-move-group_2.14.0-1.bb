# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "The move_group node for MoveIt"
AUTHOR = "Michael Görner <me@v4hn.de>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "moveit"
ROS_BPN = "moveit_ros_move_group"

ROS_BUILD_DEPENDS = " \
    fmt \
    moveit-common \
    moveit-core \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    pluginlib \
    rclcpp \
    rclcpp-action \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    fmt \
    moveit-common \
    moveit-core \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    pluginlib \
    rclcpp \
    rclcpp-action \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fmt \
    moveit-common \
    moveit-core \
    moveit-kinematics \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    pluginlib \
    rclcpp \
    rclcpp-action \
    std-srvs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    moveit-configs-utils \
    moveit-resources-fanuc-moveit-config \
    moveit-resources-panda-moveit-config \
    ros-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/moveit2-release/archive/release/rolling/moveit_ros_move_group/2.14.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/moveit_ros_move_group"
SRC_URI = "git://github.com/ros2-gbp/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "287d86d17ea744db063c405b9a6ab057ecc69ac9"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
