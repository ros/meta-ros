# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "A RACS2 Bridge demo for Curiosity mars rover"
AUTHOR = "yuyuqq <yuyuqq@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "demos"
ROS_BPN = "curiosity_rover_demo"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclpy\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclpy\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    ament-index-python\
    control-msgs\
    diff-drive-controller\
    effort-controllers\
    geometry-msgs\
    hardware-interface\
    imu-sensor-broadcaster\
    joint-state-broadcaster\
    joint-trajectory-controller\
    launch\
    launch-ros\
    robot-state-publisher\
    ros2controlcli\
    std-msgs\
    velocity-controllers\
    rclcpp\
    rclpy\
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
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/racs2_demos_on_spaceros/curiosity_rover_demo"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
