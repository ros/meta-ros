# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Aldebaran's libqi: a core library for NAOqiOS development"
AUTHOR = "Victor Paléologue <victor.paleologue@palaio.eu>"
ROS_AUTHOR = "Aldebaran"
HOMEPAGE = "http://doc.aldebaran.com/libqi"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "naoqi_libqi"
ROS_BPN = "naoqi_libqi"

ROS_BUILD_DEPENDS = " \
    boost \
    openssl \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    openssl \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    openssl \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-naoqi/libqi-release/archive/release/jazzy/naoqi_libqi/3.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/naoqi_libqi"
SRC_URI = "git://github.com/ros-naoqi/libqi-release;${ROS_BRANCH};protocol=https"
SRCREV = "0c8a4622a66db58098e99def22ddcef773d8f85a"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
