# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "MoveGroupCapabilites to interact with MoveIt"
AUTHOR = "Michael v4hn Goerner <me@v4hn.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=75730354549103aaba72b66caf53717b"

ROS_CN = "moveit_task_constructor"
ROS_BPN = "moveit_task_constructor_capabilities"

ROS_BUILD_DEPENDS = " \
    actionlib \
    moveit-core \
    moveit-ros-move-group \
    moveit-task-constructor-core \
    moveit-task-constructor-msgs \
    pluginlib \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    moveit-core \
    moveit-ros-move-group \
    moveit-task-constructor-core \
    moveit-task-constructor-msgs \
    pluginlib \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    moveit-core \
    moveit-ros-move-group \
    moveit-task-constructor-core \
    moveit-task-constructor-msgs \
    pluginlib \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/moveit_task_constructor-release/archive/release/noetic/moveit_task_constructor_capabilities/0.1.3-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/moveit_task_constructor_capabilities"
SRC_URI = "git://github.com/ros-gbp/moveit_task_constructor-release;${ROS_BRANCH};protocol=https"
SRCREV = "e6b513da58f6416bdc81a99c00420a5eb06e19a9"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
