# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Launch files for common URDF operations"
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD 3-clause"
LICENSE = "BSD-3-clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=79773b05553c027a06a89128fefb052f"

ROS_CN = "urdf_launch"
ROS_BPN = "urdf_launch"

ROS_BUILD_DEPENDS = " \
    rviz-common \
    rviz-default-plugins \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rviz-common \
    rviz-default-plugins \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    joint-state-publisher-gui \
    launch-ros \
    robot-state-publisher \
    rviz-common \
    rviz-default-plugins \
    rviz2 \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/urdf_launch-release/archive/release/rolling/urdf_launch/0.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/urdf_launch"
SRC_URI = "git://github.com/ros2-gbp/urdf_launch-release;${ROS_BRANCH};protocol=https"
SRCREV = "98979346ca0012c357de02d3e5e5929e2e01b5c4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}