# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Discover the running ROS Masters in local network. The       discovering is done by sending an echo heartbeat messages to a defined       multicast group.      The alternative is to use a zeroconf/avahi daemon to register the ROS       master as service and discover other ROS masters."
AUTHOR = "Alexander Tiderko <alexander.tiderko@gmail.com>"
ROS_AUTHOR = "Alexander Tiderko"
HOMEPAGE = "http://ros.org/wiki/master_discovery_fkie"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fkie_multimaster"
ROS_BPN = "fkie_master_discovery"

ROS_BUILD_DEPENDS = " \
    fkie-multimaster-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    fkie-multimaster-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    avahi \
    fkie-multimaster-msgs \
    rosgraph \
    roslib \
    rospy \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fkie-release/multimaster_fkie-release/archive/release/noetic/fkie_master_discovery/1.2.7-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/fkie_master_discovery"
SRC_URI = "git://github.com/fkie-release/multimaster_fkie-release;${ROS_BRANCH};protocol=https"
SRCREV = "bdccb005197ee00c538ad97e1045d7e27701e6de"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
