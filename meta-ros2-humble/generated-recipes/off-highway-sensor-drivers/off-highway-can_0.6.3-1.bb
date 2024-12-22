# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The off_highway_can package"
AUTHOR = "Robin Petereit <robin.petereit@de.bosch.com>"
ROS_AUTHOR = "Robin Petereit <robin.petereit@de.bosch.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache-2.0, MIT"
LICENSE = "Apache-2.0,-MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=470192ea0f06c8d86f4fa85047de483b"

ROS_CN = "off_highway_sensor_drivers"
ROS_BPN = "off_highway_can"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    diagnostic-updater \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    diagnostic-updater \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    diagnostic-updater \
    rclcpp \
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

# matches with: https://github.com/ros2-gbp/off_highway_sensor_drivers-release/archive/release/humble/off_highway_can/0.6.3-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/off_highway_can"
SRC_URI = "git://github.com/ros2-gbp/off_highway_sensor_drivers-release;${ROS_BRANCH};protocol=https"
SRCREV = "fb3ab4d71318616ec1b6cefed41c3360088928e5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
