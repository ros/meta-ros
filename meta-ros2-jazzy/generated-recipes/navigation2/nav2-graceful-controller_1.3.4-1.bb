# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Graceful motion controller"
AUTHOR = "Alberto Tudela <ajtudela@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "navigation2"
ROS_BPN = "nav2_graceful_controller"

ROS_BUILD_DEPENDS = " \
    angles \
    geometry-msgs \
    nav-2d-utils \
    nav2-common \
    nav2-core \
    nav2-costmap-2d \
    nav2-msgs \
    nav2-util \
    pluginlib \
    rclcpp \
    tf2 \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    geometry-msgs \
    nav-2d-utils \
    nav2-common \
    nav2-core \
    nav2-costmap-2d \
    nav2-msgs \
    nav2-util \
    pluginlib \
    rclcpp \
    tf2 \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    geometry-msgs \
    nav-2d-utils \
    nav2-common \
    nav2-core \
    nav2-costmap-2d \
    nav2-msgs \
    nav2-util \
    pluginlib \
    rclcpp \
    tf2 \
    tf2-geometry-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    nav2-controller \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/navigation2-release/archive/release/jazzy/nav2_graceful_controller/1.3.4-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/nav2_graceful_controller"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release;${ROS_BRANCH};protocol=https"
SRCREV = "2709d812885d2f4c56946077d0fdf2d29866bf73"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
