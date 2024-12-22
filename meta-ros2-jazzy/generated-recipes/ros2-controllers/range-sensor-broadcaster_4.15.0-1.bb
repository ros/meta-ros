# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Controller to publish readings of Range sensors."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Florent Chretien <flopubs@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2_controllers"
ROS_BPN = "range_sensor_broadcaster"

ROS_BUILD_DEPENDS = " \
    backward-ros \
    controller-interface \
    generate-parameter-library \
    hardware-interface \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    backward-ros \
    controller-interface \
    generate-parameter-library \
    hardware-interface \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    backward-ros \
    controller-interface \
    generate-parameter-library \
    hardware-interface \
    pluginlib \
    rclcpp \
    rclcpp-lifecycle \
    realtime-tools \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    controller-manager \
    hardware-interface-testing \
    ros2-control-test-assets \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2_controllers-release/archive/release/jazzy/range_sensor_broadcaster/4.15.0-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/range_sensor_broadcaster"
SRC_URI = "git://github.com/ros2-gbp/ros2_controllers-release;${ROS_BRANCH};protocol=https"
SRCREV = "08597d8db09f78c6b2bce8b0c594d79bb864b9af"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
