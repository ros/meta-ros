# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "This package contains the tests package for the ROS2 Planning System"
AUTHOR = "Francisco Martin Rico <fmrico@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License, Version 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=e8978a5103d23266fc6f8ec03dc9eb16"

ROS_CN = "ros2_planning_system"
ROS_BPN = "plansys2_tests"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    behaviortree-cpp \
    lifecycle-msgs \
    plansys2-domain-expert \
    plansys2-executor \
    plansys2-msgs \
    plansys2-pddl-parser \
    plansys2-planner \
    plansys2-problem-expert \
    rclcpp \
    rclcpp-action \
    rclcpp-cascade-lifecycle \
    rclcpp-lifecycle \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    behaviortree-cpp \
    lifecycle-msgs \
    plansys2-domain-expert \
    plansys2-executor \
    plansys2-msgs \
    plansys2-pddl-parser \
    plansys2-planner \
    plansys2-problem-expert \
    rclcpp \
    rclcpp-action \
    rclcpp-cascade-lifecycle \
    rclcpp-lifecycle \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    behaviortree-cpp \
    lifecycle-msgs \
    plansys2-domain-expert \
    plansys2-executor \
    plansys2-msgs \
    plansys2-pddl-parser \
    plansys2-planner \
    plansys2-problem-expert \
    popf \
    rclcpp \
    rclcpp-action \
    rclcpp-cascade-lifecycle \
    rclcpp-lifecycle \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2_planning_system-release/archive/release/jazzy/plansys2_tests/2.0.18-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/plansys2_tests"
SRC_URI = "git://github.com/ros2-gbp/ros2_planning_system-release;${ROS_BRANCH};protocol=https"
SRCREV = "1fbb2c1f21cbd75e7b943dc7f9eeca7251435254"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
