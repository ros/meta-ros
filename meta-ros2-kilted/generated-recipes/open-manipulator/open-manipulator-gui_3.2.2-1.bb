# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_kilted
inherit ros_superflore_generated

DESCRIPTION = "The OpenMANIPULATOR-X GUI ROS 2 package enables users to explore Joint Space,     Task Space, and even work with the Task Constructor functionality."
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Hye-Jong KIM <hjkim@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/open_manipulator"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "open_manipulator"
ROS_BPN = "open_manipulator_gui"

ROS_BUILD_DEPENDS = " \
    eigen3-cmake-module \
    geometry-msgs \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    qtbase \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    eigen3-cmake-module \
    geometry-msgs \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    qtbase \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    eigen3-cmake-module \
    geometry-msgs \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    qtbase \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/open_manipulator-release/archive/release/kilted/open_manipulator_gui/3.2.2-1.tar.gz
ROS_BRANCH ?= "branch=release/kilted/open_manipulator_gui"
SRC_URI = "git://github.com/ros2-gbp/open_manipulator-release;${ROS_BRANCH};protocol=https"
SRCREV = "e7538430ea47019000b06d8d78e97ceae6f10ff8"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
