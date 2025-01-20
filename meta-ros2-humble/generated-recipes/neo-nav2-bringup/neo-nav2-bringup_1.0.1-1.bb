# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "ROS-2 navigation bringup packages for neobotix robots"
AUTHOR = "Pradheep Padmanabhan <padmanabhan@neobotix.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "neo_nav2_bringup"
ROS_BPN = "neo_nav2_bringup"

ROS_BUILD_DEPENDS = " \
    nav2-common \
    navigation2 \
    slam-toolbox \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    nav2-common \
    navigation2 \
    slam-toolbox \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nav2-common \
    navigation2 \
    slam-toolbox \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/neo_nav2_bringup-release/archive/release/humble/neo_nav2_bringup/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/neo_nav2_bringup"
SRC_URI = "git://github.com/ros2-gbp/neo_nav2_bringup-release;${ROS_BRANCH};protocol=https"
SRCREV = "dc6a8b98acdbc29515b2166d3501a82da1d4fa00"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
