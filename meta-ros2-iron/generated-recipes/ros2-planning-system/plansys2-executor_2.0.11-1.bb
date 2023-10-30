# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "This package contains the Executor module for the ROS2 Planning System"
AUTHOR = "Francisco Martin Rico <fmrico@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License, Version 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=e8978a5103d23266fc6f8ec03dc9eb16"

ROS_CN = "ros2_planning_system"
ROS_BPN = "plansys2_executor"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    behaviortree-cpp-v3 \
    lifecycle-msgs \
    plansys2-core \
    plansys2-domain-expert \
    plansys2-msgs \
    plansys2-pddl-parser \
    plansys2-planner \
    plansys2-problem-expert \
    pluginlib \
    rclcpp \
    rclcpp-action \
    rclcpp-cascade-lifecycle \
    rclcpp-lifecycle \
    std-msgs \
    std-srvs \
    zeromq \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    behaviortree-cpp-v3 \
    lifecycle-msgs \
    plansys2-core \
    plansys2-domain-expert \
    plansys2-msgs \
    plansys2-pddl-parser \
    plansys2-planner \
    plansys2-problem-expert \
    pluginlib \
    rclcpp \
    rclcpp-action \
    rclcpp-cascade-lifecycle \
    rclcpp-lifecycle \
    std-msgs \
    std-srvs \
    zeromq \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    behaviortree-cpp-v3 \
    lifecycle-msgs \
    plansys2-core \
    plansys2-domain-expert \
    plansys2-msgs \
    plansys2-pddl-parser \
    plansys2-planner \
    plansys2-problem-expert \
    pluginlib \
    popf \
    rclcpp \
    rclcpp-action \
    rclcpp-cascade-lifecycle \
    rclcpp-lifecycle \
    std-msgs \
    std-srvs \
    zeromq \
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

# matches with: https://github.com/ros2-gbp/ros2_planning_system-release/archive/release/iron/plansys2_executor/2.0.11-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/plansys2_executor"
SRC_URI = "git://github.com/ros2-gbp/ros2_planning_system-release;${ROS_BRANCH};protocol=https"
SRCREV = "e0723ca2b4c9ff492ebc32338f151d3c712067b3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
