# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "C++ driver library for Kobuki:     Pure C++ driver library for Kobuki. This is for those who do not wish to use ROS on their systems."
AUTHOR = "Daniel Stonier <stonier@yujinrobot.com>"
ROS_AUTHOR = "Daniel Stonier <stonier@yujinrobot.com>"
HOMEPAGE = "http://ros.org/wiki/kobuki_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki_core"
ROS_BPN = "kobuki_driver"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-command-line \
    ecl-converters \
    ecl-devices \
    ecl-geometry \
    ecl-mobile-robot \
    ecl-sigslots \
    ecl-time \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ecl-command-line \
    ecl-converters \
    ecl-devices \
    ecl-geometry \
    ecl-mobile-robot \
    ecl-sigslots \
    ecl-time \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-command-line \
    ecl-converters \
    ecl-devices \
    ecl-geometry \
    ecl-mobile-robot \
    ecl-sigslots \
    ecl-time \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/kobuki_core-release/archive/release/kinetic/kobuki_driver/0.7.8-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1f925fdcbfbf99df7d0baebcb568f378"
SRC_URI[sha256sum] = "7376a92a141b25ec96cd9080918057e5d2d57f1d612674ff200e98f0aa0a7116"
S = "${WORKDIR}/kobuki_core-release-release-kinetic-kobuki_driver-0.7.8-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('kobuki-core', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('kobuki-core', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-core/kobuki-core_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-core/kobuki-core-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-core/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/kobuki-core/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
