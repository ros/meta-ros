# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Wrapper for the concorde traveling salesman problem solver. The code was obtained from http://www.math.uwaterloo.ca/tsp/concorde/downloads/downloads.htm all rights of it go to the corresponding authors David Applegate, Robert Bixby, Vasek Chvatal and William Cook.  The library doesn't give a specific license, but is provided free for academic research use, for further licensing options contact William Cook."
AUTHOR = "Richard Bormann <richard.bormann@ipa.fraunhofer.de>"
ROS_AUTHOR = "Florian Jordan <florian.jordan@ipa.fraunhofer.de>"
HOMEPAGE = "http://www.math.uwaterloo.ca/tsp/concorde/downloads/downloads.htm"
SECTION = "devel"
LICENSE = "free-for-academic-research,-for-further-licensing-contact-Wiliam-Cook"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=842e705ceffb0beec08938742fd91e9a"

ROS_CN = "cob_extern_unmaintained"
ROS_BPN = "libconcorde_tsp_solver"

ROS_BUILD_DEPENDS = " \
    libqsopt \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libqsopt \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libqsopt \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ipa320/cob_extern-release/archive/release/kinetic/libconcorde_tsp_solver/0.6.12-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7e480ba69d6fce758541e5cbf0a97232"
SRC_URI[sha256sum] = "6bc33bbe462860121915c9ea60425299a581c8a55ac0e925a0027258652aec61"
S = "${WORKDIR}/cob_extern-release-release-kinetic-libconcorde_tsp_solver-0.6.12-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cob-extern-unmaintained', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cob-extern-unmaintained', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-extern-unmaintained/cob-extern-unmaintained_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-extern-unmaintained/cob-extern-unmaintained-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-extern-unmaintained/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cob-extern-unmaintained/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
