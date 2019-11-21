# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Package for turtlebot3 automatic_parking. You need a reflective tape and real robots. You can see parking spot using this pacakge on rviz."
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Gilbert <kkjong@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/turtlebot3_automatic_parking"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "turtlebot3_applications"
ROS_BPN = "turtlebot3_automatic_parking"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    rospy \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    rospy \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    rospy \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/turtlebot3_applications-release/archive/release/kinetic/turtlebot3_automatic_parking/1.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b462d5a819ca76ead15e305a6b41dd1f"
SRC_URI[sha256sum] = "446f54e7e025a15b810c4a99aaf5a74252ef8965e6b267e09a85bb827042750d"
S = "${WORKDIR}/turtlebot3_applications-release-release-kinetic-turtlebot3_automatic_parking-1.1.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('turtlebot3-applications', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('turtlebot3-applications', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot3-applications/turtlebot3-applications_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot3-applications/turtlebot3-applications-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot3-applications/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/turtlebot3-applications/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
