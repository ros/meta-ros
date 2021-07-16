# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The nmea_to_geopose package"
AUTHOR = "Masaya Kataoka <ms.kataoka@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apachi 2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=a8d2b00a1367c1777b88ce4217935128"

ROS_CN = "nmea_to_geopose"
ROS_BPN = "nmea_to_geopose"

ROS_BUILD_DEPENDS = " \
    geodesy \
    geographic-msgs \
    glog \
    libeigen \
    nmea-msgs \
    quaternion-operation \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geodesy \
    geographic-msgs \
    glog \
    libeigen \
    nmea-msgs \
    quaternion-operation \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geodesy \
    geographic-msgs \
    glog \
    libeigen \
    nmea-msgs \
    quaternion-operation \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/OUXT-Polaris/nmea_to_geopose-release/archive/release/melodic/nmea_to_geopose/0.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/nmea_to_geopose"
SRC_URI = "git://github.com/OUXT-Polaris/nmea_to_geopose-release;${ROS_BRANCH};protocol=https"
SRCREV = "9678df97605a1b098e01b1473aa77b0f2afddc36"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
