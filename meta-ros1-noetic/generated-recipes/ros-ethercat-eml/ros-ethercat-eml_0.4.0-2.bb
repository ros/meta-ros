# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This is an implementation of the EtherCAT master protocol for use wiht ros_ethercar package       based on the work done at Flanders' Mechatronics Technology Centre and Willow Garage."
AUTHOR = "Shadow Robot's software team <software@shadowrobot.com>"
ROS_AUTHOR = "Tom Panis"
HOMEPAGE = "http://ros.org/wiki/ros_ethercat_eml"
SECTION = "devel"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

ROS_CN = "ros_ethercat_eml"
ROS_BPN = "ros_ethercat_eml"

ROS_BUILD_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/shadow-robot/ros_ethercat_eml-release/archive/release/noetic/ros_ethercat_eml/0.4.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ros_ethercat_eml"
SRC_URI = "git://github.com/shadow-robot/ros_ethercat_eml-release;${ROS_BRANCH};protocol=https"
SRCREV = "0c6c6605aa0e2e3399de4edaeb32c6e8cb75b11c"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
