# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Ecto bindings for the openni sensor."
AUTHOR = "Vincent Rabaud <vincent.rabaud@gmail.com>"
ROS_AUTHOR = "Ethan Rublee <erublee@willowgarage.com>"
HOMEPAGE = "http://plasmodic.github.io/ecto_openni"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ecto_openni"
ROS_BPN = "ecto_openni"

ROS_BUILD_DEPENDS = " \
    boost \
    cv-bridge \
    ecto \
    libopenni-dev \
    libusb1 \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    cv-bridge \
    ecto \
    libopenni-dev \
    libusb1 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    cv-bridge \
    ecto \
    libopenni-dev \
    libusb1 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/ecto_openni-release/archive/release/kinetic/ecto_openni/0.4.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8188539f466556f244a2c199337ec7c2"
SRC_URI[sha256sum] = "3d564af70371330d97eabcf5fe0bad79f91be74227d6eb54b9dd00a3621d831c"
S = "${WORKDIR}/ecto_openni-release-release-kinetic-ecto_openni-0.4.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ecto-openni', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ecto-openni', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-openni/ecto-openni_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-openni/ecto-openni-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-openni/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecto-openni/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
