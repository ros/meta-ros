# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "rqt_image_view provides a GUI plugin for displaying images using image_transport."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Dirk Thomas"
HOMEPAGE = "http://wiki.ros.org/rqt_image_view"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_image_view"
ROS_BPN = "rqt_image_view"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-transport \
    qt-gui-cpp \
    qtbase \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    geometry-msgs \
    image-transport \
    qt-gui-cpp \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rqt_image_view-release/archive/release/dashing/rqt_image_view/1.0.5-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/rqt_image_view"
SRC_URI = "git://github.com/ros2-gbp/rqt_image_view-release;${ROS_BRANCH};protocol=https"
SRCREV = "01289d93a1a8bcc3af6bdb94495578a9ea8c18e1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
