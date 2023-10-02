# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS messages for robots using Ackermann steering."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/ackermann_msgs"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ackermann_msgs"
ROS_BPN = "ackermann_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/ackermann_msgs-release/archive/release/melodic/ackermann_msgs/1.0.1-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/ackermann_msgs"
SRC_URI = "git://github.com/ros-drivers-gbp/ackermann_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "b3b69275c25cd85184b4218a463f11ecda0f1f1c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
