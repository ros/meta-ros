# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Gazebo worlds and ROS2 launch descriptions for Curiosity Mars Demo"
AUTHOR = "franklinselva <franklinselva10@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=162b49cfbae9eadf37c9b89b2d2ac6be"

ROS_CN = "demos"
ROS_BPN = "curiosity_gazebo"

ROS_BUILD_DEPENDS = "\
    control-msgs\
    curiosity-description\
    rclcpp\
    ament-cmake\
    ament-cmake-python\
    ros-gz\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    control-msgs\
    curiosity-description\
    rclcpp\
    ament-cmake\
    ament-cmake-python\
    ros-gz\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    gz-ros2-control\
    ros2-control\
    ros2-controllers\
    control-msgs\
    curiosity-description\
    rclcpp\
    ament-cmake\
    ament-cmake-python\
    ros-gz\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
"

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
S = "${WORKDIR}/git/curiosity_rover/curiosity_gazebo"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
