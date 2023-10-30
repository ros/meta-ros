# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Messages and service files for the ROS2 Planning System"
AUTHOR = "Francisco Martin Rico <fmrico@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License, Version 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=e8978a5103d23266fc6f8ec03dc9eb16"

ROS_CN = "ros2_planning_system"
ROS_BPN = "plansys2_msgs"

ROS_BUILD_DEPENDS = " \
    action-msgs \
    builtin-interfaces \
    rclcpp \
    rosidl-default-generators \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    action-msgs \
    builtin-interfaces \
    rclcpp \
    rosidl-default-generators \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    action-msgs \
    builtin-interfaces \
    rclcpp \
    rosidl-default-generators \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2_planning_system-release/archive/release/iron/plansys2_msgs/2.0.11-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/plansys2_msgs"
SRC_URI = "git://github.com/ros2-gbp/ros2_planning_system-release;${ROS_BRANCH};protocol=https"
SRCREV = "17b7b0f58cdba94b6e934d3af7f16c7de1070493"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
