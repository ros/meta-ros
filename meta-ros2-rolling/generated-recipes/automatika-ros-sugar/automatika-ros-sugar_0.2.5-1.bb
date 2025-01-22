# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Syntactic sugar for ROS2 nodes creation and management"
AUTHOR = "Automatika Robotics <contact@automatikarobotics.com>"
HOMEPAGE = "https://github.com/automatika/ros-sugar"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "automatika_ros_sugar"
ROS_BPN = "automatika_ros_sugar"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    lifecycle-msgs \
    nav-msgs \
    opencv \
    python3-jinja2 \
    python3-msgpack \
    python3-numpy \
    rclcpp \
    rclpy \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-python-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    lifecycle-msgs \
    nav-msgs \
    opencv \
    python3-jinja2 \
    python3-msgpack \
    python3-numpy \
    rclcpp \
    rclpy \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    lifecycle-msgs \
    nav-msgs \
    opencv \
    python3-jinja2 \
    python3-msgpack \
    python3-numpy \
    rclcpp \
    rclpy \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/automatika_ros_sugar-release/archive/release/rolling/automatika_ros_sugar/0.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/automatika_ros_sugar"
SRC_URI = "git://github.com/ros2-gbp/automatika_ros_sugar-release;${ROS_BRANCH};protocol=https"
SRCREV = "7a84edfff91cb346d323dd43f3e8dad49a59d761"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}