# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "turtle_tf2 demonstrates how to write a tf2 broadcaster and listener with the turtlesim. The tutle_tf2_listener commands turtle2 to follow turtle1 around as you drive turtle1 using the keyboard."
AUTHOR = "Denis Štogl <denis.stogl@mailbox.org>"
ROS_AUTHOR = "Denis Štogl <denis.stogl@mailbox.org>"
HOMEPAGE = "https://github.com/ros/geometry_tutorials"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geometry_tutorials"
ROS_BPN = "turtle_tf2"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    roscpp \
    rospy \
    std-msgs \
    tf2 \
    tf2-ros \
    turtlesim \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    roscpp \
    rospy \
    std-msgs \
    tf2 \
    tf2-ros \
    turtlesim \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    roscpp \
    rospy \
    std-msgs \
    tf2 \
    tf2-ros \
    turtlesim \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/geometry_tutorials-release/archive/release/kinetic/turtle_tf2/0.2.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cb6dba58eecad847c989fc133a53efe9"
SRC_URI[sha256sum] = "470185575edd830b92689f8cd433ba62767cfbcb3e7f237bfedb67a419619bbe"
S = "${WORKDIR}/geometry_tutorials-release-release-kinetic-turtle_tf2-0.2.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('geometry-tutorials', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('geometry-tutorials', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry-tutorials/geometry-tutorials_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry-tutorials/geometry-tutorials-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry-tutorials/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/geometry-tutorials/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
