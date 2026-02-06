# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Contains a set of tools that can be used from a hard\
    realtime thread, without breaking the realtime behavior.\
"
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Stuart Glaser <sglaser@willowgarage.com>"
HOMEPAGE = "https://control.ros.org"
LICENSE = "3-Clause BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=86277dc780fe4e3edb08cd487093d9de"

ROS_CN = "realtime_tools"
ROS_BPN = "realtime_tools"

ROS_BUILD_DEPENDS = "\
    ros2-control-cmake\
    boost\
    rclcpp\
    rclcpp-action\
    libcap\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    boost\
    rclcpp\
    rclcpp-action\
    libcap\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXEC_DEPENDS = "\
    boost\
    rclcpp\
    rclcpp-action\
    libcap\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gmock\
    lifecycle-msgs\
    rclcpp-lifecycle\
    test-msgs\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/realtime_tools"
SRC_URI = "git://github.com/ros2-gbp/realtime_tools-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "27c400423bbeddcb45403f8df99005bde9a9479e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
