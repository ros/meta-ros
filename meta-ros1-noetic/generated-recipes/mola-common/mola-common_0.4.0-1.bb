# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Common CMake scripts to all MOLA modules"
AUTHOR = "Jose-Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
HOMEPAGE = "https://github.com/MOLAorg/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=c1feec27682903a4270dbb401e443f91"

ROS_CN = "mola_common"
ROS_BPN = "mola_common"

ROS_BUILD_DEPENDS = " \
    ros-environment \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/mrpt-ros-pkg-release/mola_common-release/archive/release/noetic/mola_common/0.4.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mola_common"
SRC_URI = "git://github.com/mrpt-ros-pkg-release/mola_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "ba344fc24b52f4314d1f6689c5c1278a589ebe2f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
