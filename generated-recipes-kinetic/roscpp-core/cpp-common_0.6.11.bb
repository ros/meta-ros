# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "cpp_common contains C++ code for doing things that are not necessarily ROS     related, but are useful for multiple packages. This includes things like     the ROS_DEPRECATED and ROS_FORCE_INLINE macros, as well as code for getting     backtraces.      This package is a component of <a href="http://www.ros.org/wiki/roscpp">roscpp</a>."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "John Faust"
HOMEPAGE = "http://www.ros.org/wiki/cpp_common"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "roscpp_core"
ROS_BPN = "cpp_common"

ROS_BUILD_DEPENDS = " \
    boost \
    console-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    console-bridge \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    console-bridge \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/kinetic/cpp_common/0.6.11-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6b1e93da773d59991663c3ae2aeb1d06"
SRC_URI[sha256sum] = "aa7ac13928f64f5a83e3d1ed935509ed4157730a285043a27802d6006bc12ccc"
S = "${WORKDIR}/roscpp_core-release-release-kinetic-cpp_common-0.6.11-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('roscpp-core', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('roscpp-core', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roscpp-core/roscpp-core_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roscpp-core/roscpp-core-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roscpp-core/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/roscpp-core/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
