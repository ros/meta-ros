# Recipe created by ros-generate
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit ros_generate_generated

DESCRIPTION = "Eclipse iceoryx inter-process-communication (IPC) middleware basic building blocks"
AUTHOR = "Eclipse Foundation, Inc. <iceoryx-oss-support@apex.ai>"
HOMEPAGE = "https://iceoryx.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=80318c4afef111a7690eaf237460856b"

ROS_CN = "iceoryx"
ROS_BPN = "iceoryx_hoofs"

ROS_BUILD_DEPENDS = "\
    acl\
    gcc-runtime\
"

ROS_BUILDTOOL_DEPENDS = "\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    acl\
    gcc-runtime\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    acl\
    gcc-runtime\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release_2.0"
SRC_URI = "git://github.com/eclipse-iceoryx/iceoryx.git;${ROS_BRANCH};protocol=https"
SRCREV = "f756b7c99ddf714d05929374492b34c5c69355bb"
S = "${WORKDIR}/git/iceoryx_hoofs"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
