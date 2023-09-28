# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Aldebaran's libqicore: a layer on top of libqi"
AUTHOR = "Maxime Busy <mbusy@softbankrobotics.com>"
ROS_AUTHOR = "Aldebaran"
HOMEPAGE = "https://github.com/aldebaran/libqicore"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "naoqi_libqicore"
ROS_BPN = "naoqi_libqicore"

ROS_BUILD_DEPENDS = " \
    naoqi-libqi \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    naoqi-libqi \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    naoqi-libqi \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-naoqi/libqicore-release/archive/release/melodic/naoqi_libqicore/2.9.0-5.tar.gz
ROS_BRANCH ?= "branch=release/melodic/naoqi_libqicore"
SRC_URI = "git://github.com/ros-naoqi/libqicore-release;${ROS_BRANCH};protocol=https"
SRCREV = "8bf671f3a5653d1b457a5fcdb761cc935c320d97"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
