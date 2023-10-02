# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "An automatically generated package with all the configuration and launch files for using the NextageOpen with the MoveIt Motion Planning Framework."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada"
HOMEPAGE = "http://ros.org/wiki/nextage_moveit_config"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtmros_nextage"
ROS_BPN = "nextage_moveit_config"

ROS_BUILD_DEPENDS = " \
    hironx-moveit-config \
    nextage-ros-bridge \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    hironx-moveit-config \
    moveit-planners \
    moveit-ros \
    moveit-ros-move-group \
    moveit-ros-planning-interface \
    moveit-ros-visualization \
    moveit-simple-controller-manager \
    nextage-ros-bridge \
    trac-ik-kinematics-plugin \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    hironx-moveit-config \
    moveit-planners \
    moveit-ros \
    moveit-ros-move-group \
    moveit-ros-planning-interface \
    moveit-ros-visualization \
    moveit-simple-controller-manager \
    nextage-ros-bridge \
    trac-ik-kinematics-plugin \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    joint-state-publisher \
    robot-state-publisher \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/rtmros_nextage-release/archive/release/melodic/nextage_moveit_config/0.8.6-3.tar.gz
ROS_BRANCH ?= "branch=release/melodic/nextage_moveit_config"
SRC_URI = "git://github.com/tork-a/rtmros_nextage-release;${ROS_BRANCH};protocol=https"
SRCREV = "de2e4d6a4bace087bfbcea7d1586d76c46d21f8c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
