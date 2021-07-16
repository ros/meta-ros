# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Eclipse iceoryx inter-process-communication (IPC) middleware basic building blocks"
AUTHOR = "Eclipse Foundation, Inc. <michael.poehnl@apex.ai>"
HOMEPAGE = "https://iceoryx.io"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=80318c4afef111a7690eaf237460856b"

ROS_CN = "iceoryx"
ROS_BPN = "iceoryx_utils"

ROS_BUILD_DEPENDS = " \
    acl \
    gcc-runtime \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    acl \
    gcc-runtime \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    acl \
    gcc-runtime \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ApexAI/iceoryx-release/archive/release/rolling/iceoryx_utils/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/iceoryx_utils"
SRC_URI = "git://github.com/ApexAI/iceoryx-release;${ROS_BRANCH};protocol=https"
SRCREV = "770c58921d2e25d77851705151dee84e790a82d0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
