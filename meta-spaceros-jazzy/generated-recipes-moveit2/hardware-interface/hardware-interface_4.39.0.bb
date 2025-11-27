# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Base classes for hardware abstraction and tooling for them"
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "hardware_interface"
ROS_BPN = "hardware_interface"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    rcutils\
    backward-ros\
    control-msgs\
    joint-limits\
    lifecycle-msgs\
    pal-statistics\
    pluginlib\
    rclcpp-lifecycle\
    rcpputils\
    realtime-tools\
    sdformat-urdf\
    tinyxml2-vendor\
    urdf\
    fmt\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-gen-version-h-native\
"

ROS_EXPORT_DEPENDS = "\
    backward-ros\
    control-msgs\
    joint-limits\
    lifecycle-msgs\
    pal-statistics\
    pluginlib\
    rclcpp-lifecycle\
    rcpputils\
    realtime-tools\
    sdformat-urdf\
    tinyxml2-vendor\
    urdf\
    fmt\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rcutils\
    backward-ros\
    control-msgs\
    joint-limits\
    lifecycle-msgs\
    pal-statistics\
    pluginlib\
    rclcpp-lifecycle\
    rcpputils\
    realtime-tools\
    sdformat-urdf\
    tinyxml2-vendor\
    urdf\
    fmt\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    ros2-control-test-assets\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/hardware_interface"
SRC_URI = "git://github.com/ros2-gbp/ros2_control-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "f53dc4051907169d0ca9bed2ee9b1470d6eba728"
S = "${WORKDIR}/git/hardware_interface"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
