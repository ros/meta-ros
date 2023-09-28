# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "openrtm_ros_bridge package provides basic functionalities to bind     two robotics framework: <a href="http://openrtm.org/">OpenRTM</a> and ROS.<br/>     By using this package, you can write your ROS packages that communicate with your     non-ROS robots that run on OpenRTM.   		     For communicating with the robots that run on hrpsys, you can use     <a href="http://wiki.ros.org/hrpsys_ros_bridge">hrpsys_ros_bridge</a> package."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Manabu Saito <saito@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://wiki.ros.org/openrtm_ros_bridge"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtmros_common"
ROS_BPN = "openrtm_ros_bridge"

ROS_BUILD_DEPENDS = " \
    message-generation \
    openrtm-tools \
    roscpp \
    rostest \
    rtmbuild \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    openrtm-tools \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    openrtm-tools \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/rtmros_common-release/archive/release/melodic/openrtm_ros_bridge/1.4.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/openrtm_ros_bridge"
SRC_URI = "git://github.com/tork-a/rtmros_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "67a6cf060750e02daa943d1d739a9751098c1887"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
