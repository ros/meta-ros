# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Tools for directing, throttling, selecting, and otherwise messing with\
    ROS 2 topics at a meta level.\
"
AUTHOR = "Emerson Knapp <me@emersonknapp.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "topic_tools"
ROS_BPN = "topic_tools"

ROS_BUILD_DEPENDS = "\
    rclcpp\
    rclcpp-components\
    topic-tools-interfaces\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
    ament-cmake-python-native\
    rosidl-default-generators-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    rclcpp-components\
    topic-tools-interfaces\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclpy\
    ros2cli\
    rosidl-runtime-py\
    rclcpp\
    rclcpp-components\
    topic-tools-interfaces\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-common\
    ament-cmake-gtest\
    std-msgs\
    rosidl-runtime-py\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/topic_tools"
SRC_URI = "git://github.com/ros2-gbp/topic_tools-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "5373765ca5049eaba3b94b0848776b24c2197ad8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
