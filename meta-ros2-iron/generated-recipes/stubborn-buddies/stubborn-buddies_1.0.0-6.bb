# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Demo that uses node composition of lifecycle nodes to achieve fail-over robustness on ROS nodes"
AUTHOR = "Marco A. Gutiérrez <marco@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "stubborn_buddies"
ROS_BPN = "stubborn_buddies"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    rcutils \
    std-msgs \
    stubborn-buddies-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rclcpp-lifecycle \
    rcutils \
    std-msgs \
    stubborn-buddies-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/stubborn_buddies-release/archive/release/iron/stubborn_buddies/1.0.0-6.tar.gz
ROS_BRANCH ?= "branch=release/iron/stubborn_buddies"
SRC_URI = "git://github.com/ros2-gbp/stubborn_buddies-release;${ROS_BRANCH};protocol=https"
SRCREV = "5b153495968a4be9ef2c102f1bb6d16b9caf5718"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
