# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package gives transparency between RTM and ROS.       rtmros-data-bridge.py is a RT-Component for dataport/topic.      This automatically convert ROS/topic into RTM/dataport."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Manabu Saito <saito@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/rosnode_rtc"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtmros_common"
ROS_BPN = "rosnode_rtc"

ROS_BUILD_DEPENDS = " \
    openrtm-tools \
    roscpp-tutorials \
    rospy \
    rostopic \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    openrtm-tools \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    openrtm-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/rtmros_common-release/archive/release/melodic/rosnode_rtc/1.4.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rosnode_rtc"
SRC_URI = "git://github.com/tork-a/rtmros_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "4b6188d71a6a458a245a4b10b614e99927967a59"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
