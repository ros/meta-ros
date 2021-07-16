# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Extracts checkerboard corners from a dense laser snapshot.      This package is experimental and unstable. Expect its APIs to change."
AUTHOR = "David Feil-Seifer <david.feilseifer@gmail.com>"
ROS_AUTHOR = "Vijay Pradeep"
HOMEPAGE = "http://www.ros.org/wiki/laser_cb_detector"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "calibration"
ROS_BPN = "laser_cb_detector"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    cv-bridge \
    image-cb-detector \
    message-filters \
    roscpp \
    settlerlib \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    cv-bridge \
    image-cb-detector \
    message-filters \
    roscpp \
    settlerlib \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    cv-bridge \
    image-cb-detector \
    message-filters \
    roscpp \
    settlerlib \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/calibration-release/archive/release/noetic/laser_cb_detector/0.10.15-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/laser_cb_detector"
SRC_URI = "git://github.com/ros-gbp/calibration-release;${ROS_BRANCH};protocol=https"
SRCREV = "68d725c35c588a714be7f1c2901af677648ec22f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
