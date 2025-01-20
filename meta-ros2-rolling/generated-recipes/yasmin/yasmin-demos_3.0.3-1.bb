# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Demos of YASMIN (Yet Another State MachINe)"
AUTHOR = "Miguel Ángel González Santamarta <mgons@unileon.es>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f7455b89fc1cd18dbf3c0518d5d21928"

ROS_CN = "yasmin"
ROS_BPN = "yasmin_demos"

ROS_BUILD_DEPENDS = " \
    example-interfaces \
    nav-msgs \
    rclcpp \
    rclpy \
    ros-environment \
    yasmin \
    yasmin-ros \
    yasmin-viewer \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
"

ROS_EXPORT_DEPENDS = " \
    example-interfaces \
    nav-msgs \
    rclcpp \
    rclpy \
    yasmin \
    yasmin-ros \
    yasmin-viewer \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    example-interfaces \
    nav-msgs \
    rclcpp \
    rclpy \
    yasmin \
    yasmin-ros \
    yasmin-viewer \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/yasmin-release/archive/release/rolling/yasmin_demos/3.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/yasmin_demos"
SRC_URI = "git://github.com/ros2-gbp/yasmin-release;${ROS_BRANCH};protocol=https"
SRCREV = "0f1b41d53232d6b725e4323ea96ec779b5fef65d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
