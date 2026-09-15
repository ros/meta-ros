# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Support for transporting PointCloud2 messages in compressed format and plugin interface for implementing additional PointCloud2 transports."
AUTHOR = "Alejandro Hernández <alejandro@openrobotics.org>"
ROS_AUTHOR = "Jakub Paplham"
HOMEPAGE = "https://github.com/ros-perception/point_cloud_transport"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "point_cloud_transport"
ROS_BPN = "point_cloud_transport"

ROS_BUILD_DEPENDS = "\
    message-filters\
    pluginlib\
    rclcpp-components\
    rclcpp\
    rcpputils\
    rmw\
    sensor-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
    ament-cmake-gen-version-h-native\
"

ROS_EXPORT_DEPENDS = "\
    message-filters\
    pluginlib\
    rclcpp-components\
    rclcpp\
    rcpputils\
    rmw\
    sensor-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    message-filters\
    pluginlib\
    rclcpp-components\
    rclcpp\
    rcpputils\
    rmw\
    sensor-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we
# needed them to build this package (even though we actually don't) so
# that they're guaranteed to have been staged should this package appear
# in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/point_cloud_transport"
SRC_URI = "git://github.com/ros2-gbp/point_cloud_transport-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "9d5e83da5c5b079c6598923224c09803ea6b74aa"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
