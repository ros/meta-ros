# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "marti_nav_msgs"
AUTHOR = "P. J. Reed <preed@swri.org>"
HOMEPAGE = "https://github.com/swri-robotics/marti_messages"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "marti_messages"
ROS_BPN = "marti_nav_msgs"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geographic-msgs \
    geometry-msgs \
    marti-common-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    geographic-msgs \
    geometry-msgs \
    marti-common-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geographic-msgs \
    geometry-msgs \
    marti-common-msgs \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/marti_messages-release/archive/release/dashing/marti_nav_msgs/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/marti_nav_msgs"
SRC_URI = "git://github.com/ros2-gbp/marti_messages-release;${ROS_BRANCH};protocol=https"
SRCREV = "f27f7e2481bc93e492a5dae35de8a247c0d3d7f6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
