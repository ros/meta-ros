# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ros_control controller manager interface for MoveIt!"
AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
ROS_AUTHOR = "Mathias Lüdtke <mathias.luedtke@ipa.fraunhofer.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit"
ROS_BPN = "moveit_ros_control_interface"

ROS_BUILD_DEPENDS = " \
    actionlib \
    controller-manager-msgs \
    moveit-core \
    moveit-simple-controller-manager \
    pluginlib \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    controller-manager-msgs \
    moveit-core \
    moveit-simple-controller-manager \
    pluginlib \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    controller-manager-msgs \
    moveit-core \
    moveit-simple-controller-manager \
    pluginlib \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/moveit-release/archive/release/melodic/moveit_ros_control_interface/1.0.8-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/moveit_ros_control_interface"
SRC_URI = "git://github.com/ros-gbp/moveit-release;${ROS_BRANCH};protocol=https"
SRCREV = "4f96f4f34a220ab5327d5df714a1213706c37ab2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
