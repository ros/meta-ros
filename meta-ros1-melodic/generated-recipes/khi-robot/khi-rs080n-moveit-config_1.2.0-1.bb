# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "An automatically generated package with all the configuration and launch files for using the khi_rs080n with the MoveIt! Motion Planning Framework"
AUTHOR = "matsui_hiro <matsui_hiro@khi.co.jp>"
ROS_AUTHOR = "matsui_hiro <matsui_hiro@khi.co.jp>"
HOMEPAGE = "http://moveit.ros.org/"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "khi_robot"
ROS_BPN = "khi_rs080n_moveit_config"

ROS_BUILD_DEPENDS = " \
    khi-rs-description \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joint-state-publisher \
    khi-rs-description \
    moveit-fake-controller-manager \
    moveit-kinematics \
    moveit-planners-ompl \
    moveit-ros-move-group \
    moveit-ros-visualization \
    robot-state-publisher \
    rviz \
    tf \
    xacro \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    khi-rs-description \
    moveit-fake-controller-manager \
    moveit-kinematics \
    moveit-planners-ompl \
    moveit-ros-move-group \
    moveit-ros-visualization \
    robot-state-publisher \
    rviz \
    tf \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/Kawasaki-Robotics/khi_robot-release/archive/release/melodic/khi_rs080n_moveit_config/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/khi_rs080n_moveit_config"
SRC_URI = "git://github.com/Kawasaki-Robotics/khi_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "4064d75ed83967cdc6d02222d345421463774053"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
