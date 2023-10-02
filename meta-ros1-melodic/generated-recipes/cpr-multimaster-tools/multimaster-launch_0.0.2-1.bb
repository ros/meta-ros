# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Multi-master bringup launch files for CPR platforms"
AUTHOR = "Paul Bovbel <pbovbel@clearpath.ai>"
ROS_AUTHOR = "Julian Cerruti <jcerruti@creativa77.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "cpr_multimaster_tools"
ROS_BPN = "multimaster_launch"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    clock-relay \
    master-discovery-fkie \
    master-sync-fkie \
    message-relay \
    tf2-relay \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/cpr_multimaster_tools-release/archive/release/melodic/multimaster_launch/0.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/multimaster_launch"
SRC_URI = "git://github.com/clearpath-gbp/cpr_multimaster_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "9cb63a481e566e16f77814f0b13574762c9cdc8a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
