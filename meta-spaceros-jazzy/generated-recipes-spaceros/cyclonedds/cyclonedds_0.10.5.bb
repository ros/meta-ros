# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Eclipse Cyclone DDS is a very performant and robust open-source DDS implementation. Cyclone DDS is developed completely in the open as an Eclipse IoT project."
AUTHOR = "Eclipse Foundation, Inc. <cyclonedds-dev@eclipse.org>"
HOMEPAGE = "https://projects.eclipse.org/projects/iot.cyclonedds"
LICENSE = "EPL-2.0 & EDL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=7532470dee289492e850d7d3e8a32b32"

ROS_CN = "cyclonedds"
ROS_BPN = "cyclonedds"

ROS_BUILD_DEPENDS = "\
    openssl\
    iceoryx-binding-c\
    iceoryx-posh\
    iceoryx-hoofs\
"

ROS_BUILDTOOL_DEPENDS = "\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    iceoryx-binding-c\
    iceoryx-posh\
    iceoryx-hoofs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    openssl\
    iceoryx-binding-c\
    iceoryx-posh\
    iceoryx-hoofs\
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

ROS_BRANCH ?= "branch=releases/0.10.x"
SRC_URI = "git://github.com/eclipse-cyclonedds/cyclonedds.git;${ROS_BRANCH};protocol=https"
SRCREV = "2cdd114cbd18340c606573b4cc8dc20cc161ec5a"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
