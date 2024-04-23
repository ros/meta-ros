# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package wraps the libm5api to use it as a ros dependency. Original sources from http://www.schunk-modular-robotics.com/fileadmin/user_upload/software/schunk_libm5api_source.zip."
AUTHOR = "Florian Weisshardt <fmw@ipa.fhg.de>"
ROS_AUTHOR = "Florian Weisshardt <fmw@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/schunk_libm5api"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "schunk_modular_robotics"
ROS_BPN = "schunk_libm5api"

ROS_BUILD_DEPENDS = " \
    libntcan \
    libpcan \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    libntcan \
    libpcan \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libntcan \
    libpcan \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/schunk_modular_robotics-release/archive/release/noetic/schunk_libm5api/0.6.14-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/schunk_libm5api"
SRC_URI = "git://github.com/ipa320/schunk_modular_robotics-release;${ROS_BRANCH};protocol=https"
SRCREV = "34e6c76ac6d437b6c41bc7f3b9814a132b9fcc0f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}