# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The metapackage to combine the nodes required to establish and manage a multimaster network.     This requires no or minimal configuration. The changes are automatically detected and synchronized."
AUTHOR = "Alexander Tiderko <alexander.tiderko@gmail.com>"
ROS_AUTHOR = "Alexander Tiderko"
HOMEPAGE = "http://ros.org/wiki/fkie_multimaster"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fkie_multimaster"
ROS_BPN = "fkie_multimaster"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fkie-master-discovery \
    fkie-master-sync \
    fkie-multimaster-msgs \
    fkie-node-manager \
    fkie-node-manager-daemon \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fkie-release/multimaster_fkie-release/archive/release/noetic/fkie_multimaster/1.3.2-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/fkie_multimaster"
SRC_URI = "git://github.com/fkie-release/multimaster_fkie-release;${ROS_BRANCH};protocol=https"
SRCREV = "c1ac7933e28519b8020aea53d7b0abe289071f85"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
