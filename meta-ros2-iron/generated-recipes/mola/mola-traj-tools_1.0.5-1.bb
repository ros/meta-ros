# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "CLI tools to manipulate trajectory files as a complement to the evo package"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://github.com/MOLAorg/mola/tree/develop/mola_traj_tools"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=c1feec27682903a4270dbb401e443f91"

ROS_CN = "mola"
ROS_BPN = "mola_traj_tools"

ROS_BUILD_DEPENDS = " \
    mola-common \
    mrpt2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    mola-common \
    mrpt2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    mola-common \
    mrpt2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mola-release/archive/release/iron/mola_traj_tools/1.0.5-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/mola_traj_tools"
SRC_URI = "git://github.com/ros2-gbp/mola-release;${ROS_BRANCH};protocol=https"
SRCREV = "5a45128c8e0e0aa802b848e5b11956b0be7f7098"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
