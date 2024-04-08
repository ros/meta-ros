# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Control tools GUI"
AUTHOR = "Francisco Martín Rico <fmrico@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=c93e37fc0c6f510db5735eb91dcc1550"

ROS_CN = "mocap4r2"
ROS_BPN = "rqt_mocap4r2_control"

ROS_BUILD_DEPENDS = " \
    mocap4r2-control \
    mocap4r2-control-msgs \
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
    mocap4r2-control \
    mocap4r2-control-msgs \
    qt-gui-cpp \
    qtbase \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mocap4r2-control \
    mocap4r2-control-msgs \
    qt-gui-cpp \
    qtbase \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    sensor-msgs \
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

# matches with: https://github.com/MOCAP4ROS2-Project/mocap4r2-release/archive/release/humble/rqt_mocap4r2_control/0.0.7-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/rqt_mocap4r2_control"
SRC_URI = "git://github.com/MOCAP4ROS2-Project/mocap4r2-release;${ROS_BRANCH};protocol=https"
SRCREV = "a17431dad65ba6d49fb1c6cf4146b51790d944b5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}