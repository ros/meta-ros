# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package is used to manually control a robot that uses the operator and     navigator node from navigation_2d. Currently there is one node to control one     robot with a joystick and one to control multiple robots in simulation.     It can send commands directly to the operator or start and stop navigator actions."
AUTHOR = "Sebastian Kasperski <sebastian.kasperski@dfki.de>"
ROS_AUTHOR = "Sebastian Kasperski <sebastian.kasperski@dfki.de>"
HOMEPAGE = "http://wiki.ros.org/remote_controller"
SECTION = "devel"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "navigation_2d"
ROS_BPN = "nav2d_remote"

ROS_BUILD_DEPENDS = " \
    nav2d-navigator \
    nav2d-operator \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    nav2d-navigator \
    nav2d-operator \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nav2d-navigator \
    nav2d-operator \
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

SRC_URI = "https://github.com/skasperski/navigation_2d-release/archive/release/kinetic/nav2d_remote/0.3.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "64303673be673bc08280dec6a5c3b0db"
SRC_URI[sha256sum] = "cbe3f593863b80821ae7700cd3d457c46a3118f2141b674167e51267b62acdb6"
S = "${WORKDIR}/navigation_2d-release-release-kinetic-nav2d_remote-0.3.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('navigation-2d', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('navigation-2d', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-2d/navigation-2d_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-2d/navigation-2d-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-2d/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/navigation-2d/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
