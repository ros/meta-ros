# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "gz_ros2_control_demos"
AUTHOR = "Alejandro Hernandez <ahcorde@osrfoundation.org>"
ROS_AUTHOR = "Alejandro Hernández"
HOMEPAGE = "https://github.com/ros-controls/gz_ros2_control/blob/master/README.md"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "gz_ros2_control"
ROS_BPN = "gz_ros2_control_demos"

ROS_BUILD_DEPENDS = " \
    control-msgs \
    geometry-msgs \
    rclcpp \
    rclcpp-action \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ackermann-steering-controller \
    ament-index-python \
    control-msgs \
    diff-drive-controller \
    effort-controllers \
    geometry-msgs \
    gz-ros2-control \
    hardware-interface \
    imu-sensor-broadcaster \
    joint-state-broadcaster \
    joint-trajectory-controller \
    launch \
    launch-ros \
    rclcpp \
    robot-state-publisher \
    ros-gz-bridge \
    ros-gz-sim \
    ros2controlcli \
    ros2launch \
    std-msgs \
    tricycle-controller \
    velocity-controllers \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ign_ros2_control-release/archive/release/rolling/gz_ros2_control_demos/2.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/gz_ros2_control_demos"
SRC_URI = "git://github.com/ros2-gbp/ign_ros2_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "c571fcf46fbdca658c807be858ea229df5549f8b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
