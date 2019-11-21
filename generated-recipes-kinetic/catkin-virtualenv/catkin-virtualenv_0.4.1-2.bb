# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Bundle python requirements in a catkin package via virtualenv."
AUTHOR = "Paul Bovbel <pbovbel@locusrobotics.com>"
ROS_AUTHOR = "Paul Bovbel <pbovbel@locusrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "GPL-1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=21;endline=21;md5=d6fd5bd8a2ca0ce00c65331b4263470b"

ROS_CN = "catkin_virtualenv"
ROS_BPN = "catkin_virtualenv"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    python-enum34 \
    python-packaging-native \
    python-virtualenv \
    python3 \
    python3-venv \
    rosbash \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/locusrobotics/catkin_virtualenv-release/archive/release/kinetic/catkin_virtualenv/0.4.1-2.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "66b78318ca628680c23219ad6e7c322a"
SRC_URI[sha256sum] = "0c94219f3da044a049f8847ce47e17318537a8ccc1dd82a277dc06f2d7609b64"
S = "${WORKDIR}/catkin_virtualenv-release-release-kinetic-catkin_virtualenv-0.4.1-2"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('catkin-virtualenv', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('catkin-virtualenv', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/catkin-virtualenv/catkin-virtualenv_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/catkin-virtualenv/catkin-virtualenv-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/catkin-virtualenv/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/catkin-virtualenv/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
