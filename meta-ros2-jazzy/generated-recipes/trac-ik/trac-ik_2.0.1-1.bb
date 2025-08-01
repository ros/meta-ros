# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "The ROS packages in this repository were created to provide an improved     alternative Inverse Kinematics solver to the popular inverse Jacobian     methods in KDL.  TRAC-IK handles joint-limited chains better than KDL     without increasing solve time."
AUTHOR = "TRACLabs Robotics <robotics@traclabs.com>"
ROS_AUTHOR = "Patrick Beeson"
HOMEPAGE = "http://wiki.ros.org/trac_ik"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "trac_ik"
ROS_BPN = "trac_ik"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    trac-ik-kinematics-plugin \
    trac-ik-lib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/trac_ik-release/archive/release/jazzy/trac_ik/2.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/trac_ik"
SRC_URI = "git://github.com/ros2-gbp/trac_ik-release;${ROS_BRANCH};protocol=https"
SRCREV = "92b5f9f982498bed253e7fe0aaccabb177014abb"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
