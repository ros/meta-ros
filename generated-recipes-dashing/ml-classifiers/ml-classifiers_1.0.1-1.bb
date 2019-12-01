# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "ml_classifiers"
AUTHOR = "AutonomouStuff Software Development Team <software@autonomoustuff.com>"
ROS_AUTHOR = "Scott Niekum <sniekum@cs.utexas.edu>"
HOMEPAGE = "http://wiki.ros.org/ml_classifiers"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ml_classifiers"
ROS_BPN = "ml_classifiers"

ROS_BUILD_DEPENDS = " \
    libeigen \
    pluginlib \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ros-environment-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    pluginlib \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    pluginlib \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/astuff/ml_classifiers-release/archive/release/dashing/ml_classifiers/1.0.1-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a2cc6d987c10ba2e6e42ba73f1462097"
SRC_URI[sha256sum] = "f054c83fe2351cd04afb3fdf0f358ad0749ee969715724474add442c3f4721bf"
S = "${WORKDIR}/ml_classifiers-release-release-dashing-ml_classifiers-1.0.1-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('ml-classifiers', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('ml-classifiers', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ml-classifiers/ml-classifiers_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ml-classifiers/ml-classifiers-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ml-classifiers/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/ml-classifiers/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
