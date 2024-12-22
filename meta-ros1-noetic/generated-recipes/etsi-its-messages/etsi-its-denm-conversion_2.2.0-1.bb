# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Conversion functions for converting ROS messages to and from ASN.1-encoded ETSI ITS DENMs"
AUTHOR = "Jean-Pierre Busch <jean-pierre.busch@rwth-aachen.de>"
ROS_AUTHOR = "Jean-Pierre Busch <jean-pierre.busch@rwth-aachen.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "etsi_its_messages"
ROS_BPN = "etsi_its_denm_conversion"

ROS_BUILD_DEPENDS = " \
    etsi-its-denm-coding \
    etsi-its-denm-msgs \
    etsi-its-primitives-conversion \
    ros-environment \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    etsi-its-denm-coding \
    etsi-its-denm-msgs \
    etsi-its-primitives-conversion \
    ros-environment \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    etsi-its-denm-coding \
    etsi-its-denm-msgs \
    etsi-its-primitives-conversion \
    ros-environment \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ika-rwth-aachen/etsi_its_messages-release/archive/release/noetic/etsi_its_denm_conversion/2.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/etsi_its_denm_conversion"
SRC_URI = "git://github.com/ika-rwth-aachen/etsi_its_messages-release;${ROS_BRANCH};protocol=https"
SRCREV = "9295bf54269c63910d41c58edc18bc6a77fa458c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
