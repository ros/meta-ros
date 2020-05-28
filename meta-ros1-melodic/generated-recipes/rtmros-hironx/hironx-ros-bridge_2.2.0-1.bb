# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS-OpenRTM interfacing package for the opensource version of Kawada's Hiro/NEXTAGE dual-arm robot.    NOTE: This package is multi-license -- pay attention to file header in each file where license is declared. For Creative Commons nc 4.0 applied, see <a href="http://creativecommons.org/licenses/by-nc/4.0">here</a>.    <p>This package also contains some sensor driver software (as of April 2016 they are the following force sensors such as <a href="http://www.wacoh-tech.com/products/dynpick/wdf-6m200-3.html">Dynpick</a> and <a href="http://www.jr3.com/products.html">JR3</a>) for QNX. These drivers are stored in this robot-specific package for not many reasons than they are slightly customized for the robot. So if you can separate those as a standalone, generic package that'll be appreciated (please just let us know if you will).</p>"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/hironx_ros_bridge"
SECTION = "devel"
LICENSE = "BSD & CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=0e0fd756017bccbfdb4e935c7573a4ae"

ROS_CN = "rtmros_hironx"
ROS_BPN = "hironx_ros_bridge"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gnuplot} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_unzip} \
    control-msgs \
    hrpsys-ros-bridge \
    mk \
    rosbash \
    rosbuild \
    roslang \
    roslib \
    roslint \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gnuplot} \
    control-msgs \
    hrpsys-ros-bridge \
    moveit-commander \
    openni2-launch \
    rosbash \
    roslang \
    roslib \
    rospy \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gnuplot} \
    control-msgs \
    hrpsys-ros-bridge \
    moveit-commander \
    openni2-launch \
    rosbash \
    roslang \
    roslib \
    rospy \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/rtmros_hironx-release/archive/release/melodic/hironx_ros_bridge/2.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/hironx_ros_bridge"
SRC_URI = "git://github.com/tork-a/rtmros_hironx-release;${ROS_BRANCH};protocol=https"
SRCREV = "afea100f4991478e1229e49fae9aea2995368563"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
