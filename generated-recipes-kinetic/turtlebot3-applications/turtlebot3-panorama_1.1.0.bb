# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This app utilises pano_ros for taking snapshots and stitching them together to create panorama pictures."
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Younghun Ju"
HOMEPAGE = "http://wiki.ros.org/turtlebot3_panorama"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "turtlebot3_applications"
ROS_BPN = "turtlebot3_panorama"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    cv-bridge \
    geometry-msgs \
    image-transport \
    libeigen \
    nav-msgs \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    turtlebot3-applications-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cmake-modules \
    cv-bridge \
    geometry-msgs \
    image-transport \
    libeigen \
    nav-msgs \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    turtlebot3-applications-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cmake-modules \
    cv-bridge \
    geometry-msgs \
    image-transport \
    libeigen \
    nav-msgs \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    turtlebot3-applications-msgs \
    turtlebot3-bringup \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/turtlebot3_applications-release/archive/release/kinetic/turtlebot3_panorama/1.1.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "df0a059c450654aaf51665302d3462cc"
SRC_URI[sha256sum] = "a09e7cce6b1fd67ad4656fb7db673c21cf1b79742e45d5f0379de2ea1c74bb4e"
S = "${WORKDIR}/turtlebot3_applications-release-release-kinetic-turtlebot3_panorama-1.1.0-0"

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
