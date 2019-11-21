# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The follow_waypoints node will listen for waypoints given as       poses and when instructed will follow them one by one by publishing goals       to move_base."
AUTHOR = "Daniel Snider <danielsnider12@gmail.com>"
ROS_AUTHOR = "Daniel Snider <danielsnider12@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/follow_waypoints"
SECTION = "devel"
LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=c4d59f93d1cbaf4d216df2c1b2ed0dca"

ROS_CN = "follow_waypoints"
ROS_BPN = "follow_waypoints"

ROS_BUILD_DEPENDS = " \
    actionlib \
    geometry-msgs \
    move-base-msgs \
    rospy \
    smach \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    geometry-msgs \
    move-base-msgs \
    rospy \
    smach \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    geometry-msgs \
    move-base-msgs \
    rospy \
    smach \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/danielsnider/follow_waypoints-release/archive/release/kinetic/follow_waypoints/0.3.0-2.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "58682c2bf04a5c9cd69ad22254142277"
SRC_URI[sha256sum] = "3a70c85f6a6c6c0e35348b7372e496303e94a8cedaf87da5395077c3add3a329"
S = "${WORKDIR}/follow_waypoints-release-release-kinetic-follow_waypoints-0.3.0-2"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('follow-waypoints', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('follow-waypoints', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/follow-waypoints/follow-waypoints_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/follow-waypoints/follow-waypoints-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/follow-waypoints/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/follow-waypoints/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
