# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The tools package(including SLAM, Navigation, Manipulation) for OpenManipulator with TurtleBot3"
AUTHOR = "Pyo <pyo@robotis.com>"
ROS_AUTHOR = "Darby Lim <thlim@robotis.com>"
HOMEPAGE = "http://wiki.ros.org/open_manipulator_with_tb3_tools"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "open_manipulator_with_tb3"
ROS_BPN = "open_manipulator_with_tb3_tools"

ROS_BUILD_DEPENDS = " \
    ar-track-alvar-msgs \
    geometry-msgs \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    nav-msgs \
    open-manipulator-msgs \
    roscpp \
    roslaunch \
    rospy \
    smach \
    smach-ros \
    std-msgs \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ar-track-alvar-msgs \
    geometry-msgs \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    nav-msgs \
    open-manipulator-msgs \
    roscpp \
    roslaunch \
    rospy \
    smach \
    smach-ros \
    std-msgs \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    amcl \
    ar-track-alvar-msgs \
    geometry-msgs \
    joint-state-publisher \
    map-server \
    move-base \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    nav-msgs \
    open-manipulator-msgs \
    robot-state-publisher \
    roscpp \
    roslaunch \
    rospy \
    smach \
    smach-ros \
    std-msgs \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ROBOTIS-GIT-release/open_manipulator_with_tb3-release/archive/release/melodic/open_manipulator_with_tb3_tools/1.1.0-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/open_manipulator_with_tb3_tools"
SRC_URI = "git://github.com/ROBOTIS-GIT-release/open_manipulator_with_tb3-release;${ROS_BRANCH};protocol=https"
SRCREV = "eb20951c77e61ac7e7cd88675f87327293f5dd78"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
