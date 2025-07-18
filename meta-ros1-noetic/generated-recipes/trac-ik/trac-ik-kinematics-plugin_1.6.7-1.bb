# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A MoveIt! Kinematics plugin using TRAC-IK"
AUTHOR = "TRACLabs Robotics <robotics@traclabs.com>"
ROS_AUTHOR = "Patrick Beeson"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "trac_ik"
ROS_BPN = "trac_ik_kinematics_plugin"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libnlopt-cxx-dev} \
    ${ROS_UNRESOLVED_DEP-libnlopt-dev} \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
    trac-ik-lib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libnlopt-dev} \
    ${ROS_UNRESOLVED_DEP-libnlopt0} \
    moveit-core \
    pluginlib \
    roscpp \
    tf-conversions \
    trac-ik-lib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/traclabs/trac_ik-release/archive/release/noetic/trac_ik_kinematics_plugin/1.6.7-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/trac_ik_kinematics_plugin"
SRC_URI = "git://github.com/traclabs/trac_ik-release;${ROS_BRANCH};protocol=https"
SRCREV = "923797a13014c326b356afdae0141153533f0781"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
