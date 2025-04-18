# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "ROS2 camera driver for [GenICam](https://www.emva.org/standards-technology/genicam/)-based GigEVision and USB3Vision cameras."
AUTHOR = "Raphael Hagmanns <raphael.hagmanns@iosb.fraunhofer.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "camera_aravis2"
ROS_BPN = "camera_aravis2"

ROS_BUILD_DEPENDS = " \
    aravis \
    camera-aravis2-msgs \
    camera-info-manager \
    cv-bridge \
    diagnostic-msgs \
    glib-2.0 \
    image-transport \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-aravis2-msgs \
    camera-info-manager \
    cv-bridge \
    diagnostic-msgs \
    image-transport \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-aravis2-msgs \
    camera-info-manager \
    cv-bridge \
    diagnostic-msgs \
    image-transport \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/camera_aravis2-release/archive/release/humble/camera_aravis2/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/camera_aravis2"
SRC_URI = "git://github.com/ros2-gbp/camera_aravis2-release;${ROS_BRANCH};protocol=https"
SRCREV = "350b27884f89213e387eaeb308bb2fe23acd345d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
