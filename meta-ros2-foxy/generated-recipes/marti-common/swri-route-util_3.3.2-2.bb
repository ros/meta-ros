# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "This library provides functionality to simplify working with the     navigation messages defined in marti_nav_msgs."
AUTHOR = "P. J. Reed <preed@swri.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "marti_common"
ROS_BPN = "swri_route_util"

ROS_BUILD_DEPENDS = " \
    boost \
    marti-common-msgs \
    marti-nav-msgs \
    rclcpp \
    swri-geometry-util \
    swri-math-util \
    swri-roscpp \
    swri-transform-util \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    marti-common-msgs \
    marti-nav-msgs \
    rclcpp \
    swri-geometry-util \
    swri-math-util \
    swri-roscpp \
    swri-transform-util \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    marti-common-msgs \
    marti-nav-msgs \
    rclcpp \
    swri-geometry-util \
    swri-math-util \
    swri-roscpp \
    swri-transform-util \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/swri-robotics-gbp/marti_common-release/archive/release/foxy/swri_route_util/3.3.2-2.tar.gz
ROS_BRANCH ?= "branch=release/foxy/swri_route_util"
SRC_URI = "git://github.com/swri-robotics-gbp/marti_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "9d7733b1b7348869c787bc64381f81f22a8c25e7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
