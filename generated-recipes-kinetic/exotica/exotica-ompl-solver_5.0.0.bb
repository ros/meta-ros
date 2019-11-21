# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Exotica solvers based on the Open Motion Planning Libary (OMPL)"
AUTHOR = "Yiming Yang <yiming.yang@ed.ac.uk>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "exotica"
ROS_BPN = "exotica_ompl_solver"

ROS_BUILD_DEPENDS = " \
    exotica-core \
    exotica-python \
    ompl \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    exotica-core \
    exotica-python \
    ompl \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    exotica-core \
    exotica-python \
    ompl \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipab-slmc/exotica-release/archive/release/kinetic/exotica_ompl_solver/5.0.0-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7e71e2d77118ffa281950426eaf74c26"
SRC_URI[sha256sum] = "31f73a27db8af3a3f662b5fba756411e41397a2e5c51b9260f4e868416a688fe"
S = "${WORKDIR}/exotica-release-release-kinetic-exotica_ompl_solver-5.0.0-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('exotica', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('exotica', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/exotica/exotica_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/exotica/exotica-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/exotica/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/exotica/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
