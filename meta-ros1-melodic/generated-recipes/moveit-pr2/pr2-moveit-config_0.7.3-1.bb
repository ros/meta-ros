# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "An automatically generated package with all the configuration and launch files for using the pr2 with the MoveIt Motion Planning Framework"
AUTHOR = "MoveIt Setup Assistant <assistant@moveit.ros.org>"
ROS_AUTHOR = "MoveIt Setup Assistant <assistant@moveit.ros.org>"
HOMEPAGE = "http://moveit.ros.org/"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit_pr2"
ROS_BPN = "pr2_moveit_config"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    moveit-ros-move-group \
    pr2-description \
    robot-state-publisher \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/moveit_pr2-release/archive/release/melodic/pr2_moveit_config/0.7.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2_moveit_config"
SRC_URI = "git://github.com/ros-gbp/moveit_pr2-release;${ROS_BRANCH};protocol=https"
SRCREV = "af95b06d279bd67f4476d6812841f59f7c62c55d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
