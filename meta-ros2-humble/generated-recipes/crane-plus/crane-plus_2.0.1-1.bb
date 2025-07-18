# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "ROS 2 package suite of CRANE+ V2"
AUTHOR = "RT Corporation <shop@rt-net.jp>"
ROS_AUTHOR = "Shota Aoki <s.aoki@rt-net.jp>"
HOMEPAGE = "https://rt-net.jp/products/cranev2/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "crane_plus"
ROS_BPN = "crane_plus"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    crane-plus-control \
    crane-plus-description \
    crane-plus-examples \
    crane-plus-gazebo \
    crane-plus-moveit-config \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/crane_plus-release/archive/release/humble/crane_plus/2.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/crane_plus"
SRC_URI = "git://github.com/ros2-gbp/crane_plus-release;${ROS_BRANCH};protocol=https"
SRCREV = "2000776fbfae0026c328aa3a72359071c5484d0a"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
