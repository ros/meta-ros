# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Package for all inverse kinematics solvers in MoveIt"
AUTHOR = "Dave Coleman <dave@picknik.ai>"
ROS_AUTHOR = "Dave Coleman <dave@picknik.ai>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit"
ROS_BPN = "moveit_kinematics"

ROS_BUILD_DEPENDS = " \
    class-loader \
    libeigen \
    moveit-common \
    moveit-core \
    moveit-msgs \
    orocos-kdl \
    pluginlib \
    tf2 \
    tf2-kdl \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    class-loader \
    libeigen \
    moveit-core \
    moveit-msgs \
    orocos-kdl \
    pluginlib \
    tf2 \
    tf2-kdl \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-lxml \
    class-loader \
    libeigen \
    moveit-core \
    moveit-msgs \
    orocos-kdl \
    pluginlib \
    tf2 \
    tf2-kdl \
    urdfdom \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    moveit-resources-fanuc-description \
    moveit-resources-fanuc-moveit-config \
    moveit-resources-panda-description \
    moveit-resources-panda-moveit-config \
    moveit-ros-planning \
    ros-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/moveit/moveit2-release/archive/release/rolling/moveit_kinematics/2.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/moveit_kinematics"
SRC_URI = "git://github.com/moveit/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "f450e1d5cc4d0f387c3293ad2db6c3ab6eff7bf3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
