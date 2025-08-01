# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "URDF description of the MiR robot"
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
ROS_AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
HOMEPAGE = "https://github.com/DFKI-NI/mir_robot"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "mir_robot"
ROS_BPN = "mir_description"

ROS_BUILD_DEPENDS = " \
    roslaunch \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diff-drive-controller \
    gazebo-plugins \
    gazebo-ros-control \
    hector-gazebo-plugins \
    joint-state-controller \
    joint-state-publisher \
    joint-state-publisher-gui \
    position-controllers \
    robot-state-publisher \
    rviz \
    urdf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/uos-gbp/mir_robot-release/archive/release/noetic/mir_description/1.1.8-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mir_description"
SRC_URI = "git://github.com/uos-gbp/mir_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "fe73c54a73ff4dad6b7f1064641ccea5f6bfd178"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
