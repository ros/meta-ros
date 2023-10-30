# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "AprilTag detection node"
AUTHOR = "Christian Rauch <Rauch.Christian@gmx.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "apriltag_ros"
ROS_BPN = "apriltag_ros"

ROS_BUILD_DEPENDS = " \
    apriltag \
    apriltag-msgs \
    cv-bridge \
    image-transport \
    libeigen \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    apriltag \
    apriltag-msgs \
    cv-bridge \
    image-transport \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    apriltag \
    apriltag-msgs \
    cv-bridge \
    image-transport \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-clang-format \
    ament-cmake-cppcheck \
    ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/apriltag_ros-release/archive/release/iron/apriltag_ros/3.1.1-4.tar.gz
ROS_BRANCH ?= "branch=release/iron/apriltag_ros"
SRC_URI = "git://github.com/ros2-gbp/apriltag_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "825eba4950ffb107339d4f0740167c8589ab034e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
