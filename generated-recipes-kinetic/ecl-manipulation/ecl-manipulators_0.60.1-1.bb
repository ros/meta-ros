# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Deploys various manipulation algorithms, currently just      feedforward filters (interpolations)."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/ecl_manipulators"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ecl_manipulation"
ROS_BPN = "ecl_manipulators"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-exceptions \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ecl-build \
    ecl-exceptions \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-build \
    ecl-exceptions \
    ecl-formatters \
    ecl-geometry \
    ecl-license \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/ecl_manipulation-release/archive/release/kinetic/ecl_manipulators/0.60.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "61b78731fcf53b17d2bd1dcff3fa2015"
SRC_URI[sha256sum] = "7e26de305073066fc8e1025448dfbf33af8b5b0a2f464495ec43c0e1e7224730"
S = "${WORKDIR}/ecl_manipulation-release-release-kinetic-ecl_manipulators-0.60.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ecl-manipulation', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ecl-manipulation', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-manipulation/ecl-manipulation_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-manipulation/ecl-manipulation-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-manipulation/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ecl-manipulation/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
