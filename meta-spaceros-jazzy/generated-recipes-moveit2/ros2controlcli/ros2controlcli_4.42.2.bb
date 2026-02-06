# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "The ROS 2 command line tools for ros2_control."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Victor Lopez <victor.lopez@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2controlcli"
ROS_BPN = "ros2controlcli"

ROS_BUILD_DEPENDS = "\
    rcl-interfaces\
    rclpy\
    ros2cli\
    ros2node\
    ros2param\
    controller-manager\
    controller-manager-msgs\
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = "\
    rcl-interfaces\
    rclpy\
    ros2cli\
    ros2node\
    ros2param\
    controller-manager\
    controller-manager-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-runtime-py\
    python3-pygraphviz\
    rcl-interfaces\
    rclpy\
    ros2cli\
    ros2node\
    ros2param\
    controller-manager\
    controller-manager-msgs\
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

ROS_BRANCH ?= "branch=release/jazzy/ros2controlcli"
SRC_URI = "git://github.com/ros2-gbp/ros2_control-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "93048bc4c229ab0edcefb8e0d970348f46c8bbfc"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
