# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS messages for robots using FourWheelSteering."
AUTHOR = "Vincent Rousseau <vincentrou@gmail.com>"
ROS_AUTHOR = "Vincent Rousseau <vincentrou@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/four_wheel_steering_msgs"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "four_wheel_steering_msgs"
ROS_BPN = "four_wheel_steering_msgs"

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

# matches with: https://github.com/ros-drivers-gbp/four_wheel_steering_msgs-release/archive/release/noetic/four_wheel_steering_msgs/1.1.1-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/four_wheel_steering_msgs"
SRC_URI = "git://github.com/ros-drivers-gbp/four_wheel_steering_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "6048943d2188bd28a3ff9ccc6e15944660dcdc05"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
