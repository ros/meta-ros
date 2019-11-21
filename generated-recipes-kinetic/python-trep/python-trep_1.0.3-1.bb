# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Trep: Mechanical Simulation and Optimal Control Software"
AUTHOR = "Jarvis Schultz <jschultz@northwestern.edu>"
ROS_AUTHOR = "Elliot Johnson"
HOMEPAGE = "http://nxr.northwestern.edu/trep"
SECTION = "devel"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "python_trep"
ROS_BPN = "python_trep"

ROS_BUILD_DEPENDS = " \
    freeglut \
    python \
    python-imaging \
    python-matplotlib \
    python-numpy \
    python-opengl \
    python-qt-bindings \
    python-qt-bindings-gl \
    python-scipy \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    freeglut \
    python \
    python-imaging \
    python-matplotlib \
    python-numpy \
    python-opengl \
    python-qt-bindings \
    python-qt-bindings-gl \
    python-scipy \
    rospy \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    freeglut \
    python \
    python-imaging \
    python-matplotlib \
    python-numpy \
    python-opengl \
    python-qt-bindings \
    python-qt-bindings-gl \
    python-scipy \
    rospy \
    sensor-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/MurpheyLab/trep-release/archive/release/kinetic/python_trep/1.0.3-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "84a2b8f31781a549c98a91028894bc4d"
SRC_URI[sha256sum] = "8b4fdb09a82cba7b0f1ca40d6d4790b2c0d09fd7002d2d1cba01078196ce7b5d"
S = "${WORKDIR}/trep-release-release-kinetic-python_trep-1.0.3-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('python-trep', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('python-trep', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/python-trep/python-trep_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/python-trep/python-trep-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/python-trep/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/python-trep/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
