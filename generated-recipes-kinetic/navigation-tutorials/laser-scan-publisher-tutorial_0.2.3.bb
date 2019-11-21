# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The laser_scan_publisher_tutorial package"
AUTHOR = "William Woodall <william@osrfoundation.org>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://ros.org/wiki/laser_scan_publisher_tutorial"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "navigation_tutorials"
ROS_BPN = "laser_scan_publisher_tutorial"

ROS_BUILD_DEPENDS = " \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/navigation_tutorials-release/archive/release/kinetic/laser_scan_publisher_tutorial/0.2.3-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b24ffbdfdde5cae0da72aba94589c39a"
SRC_URI[sha256sum] = "240f40c3a13ec6e9b0947b95666f2764eab2fb735ac4bb70a19a2f90dea1e768"
S = "${WORKDIR}/navigation_tutorials-release-release-kinetic-laser_scan_publisher_tutorial-0.2.3-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('navigation-tutorials', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('navigation-tutorials', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-tutorials/navigation-tutorials_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-tutorials/navigation-tutorials-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-tutorials/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-tutorials/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
