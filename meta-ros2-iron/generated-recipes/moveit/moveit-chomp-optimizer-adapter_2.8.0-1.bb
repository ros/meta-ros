# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "MoveIt planning request adapter utilizing chomp for solution optimization"
AUTHOR = "Raghavender Sahdev <raghavendersahdev@gmail.com>"
ROS_AUTHOR = "Raghavender Sahdev <raghavendersahdev@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "moveit"
ROS_BPN = "moveit_chomp_optimizer_adapter"

ROS_BUILD_DEPENDS = " \
    chomp-motion-planner \
    moveit-common \
    moveit-core \
    pluginlib \
    rsl \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    chomp-motion-planner \
    moveit-common \
    moveit-core \
    pluginlib \
    rsl \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    chomp-motion-planner \
    moveit-common \
    moveit-core \
    pluginlib \
    rsl \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/moveit2-release/archive/release/iron/moveit_chomp_optimizer_adapter/2.8.0-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/moveit_chomp_optimizer_adapter"
SRC_URI = "git://github.com/ros2-gbp/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "7750ce61725de6106b945a08a521fbe0e2405284"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
