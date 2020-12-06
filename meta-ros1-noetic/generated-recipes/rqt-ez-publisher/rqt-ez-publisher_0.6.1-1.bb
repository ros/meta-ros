# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The rqt_ez_publisher package"
AUTHOR = "Takashi Ogura <t.ogura@gmail.com>"
ROS_AUTHOR = "Takashi Ogura <t.ogura@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/rqt_ez_publisher"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_ez_publisher"
ROS_BPN = "rqt_ez_publisher"

ROS_BUILD_DEPENDS = " \
    python3-catkin-pkg \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    rospy \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
    tf \
    tf2-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    rospy \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
    tf \
    tf2-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    sensor-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/OTL/rqt_ez_publisher-release/archive/release/noetic/rqt_ez_publisher/0.6.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rqt_ez_publisher"
SRC_URI = "git://github.com/OTL/rqt_ez_publisher-release;${ROS_BRANCH};protocol=https"
SRCREV = "967d8500611524b02bd1b82f5e6ad6d40e20e707"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
