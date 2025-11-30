# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "CanadArm2 Control demo using SpaceROS"
AUTHOR = "root <tonylitianyu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "TODO: License declaration"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=782925c2d55d09052e1842a0b4886802"

ROS_CN = "demos"
ROS_BPN = "canadarm_demo"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclpy\
    action-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
    rosidl-default-generators-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclpy\
    action-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    ament-index-python\
    geometry-msgs\
    launch\
    launch-ros\
    std-msgs\
    rclcpp\
    rclpy\
    action-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=main"
SRC_URI = "git://github.com/space-ros/demos.git;${ROS_BRANCH};protocol=https"
SRCREV = "acf369b3fa1c8a64ff40b649b80c5540a6fac970"
S = "${WORKDIR}/git/canadarm2/canadarm_demo"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
