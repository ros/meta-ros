# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "HyQ-robot specific functions for visualization in the  XPP Motion Framework.          These include inverse kinematics as well as urdf files for a one-legged,     two-legged and four legged robot with <a href="http://dls.iit.it/">HyQ</a>     legs.              The dynamic model can be found      <a href="https://github.com/iit-DLSLab/hyq-description">here</a>.            See also <a href="https://dls.iit.it">IIT</a>."
AUTHOR = "Alexander W. Winkler <alexander.w.winkler@gmail.com>"
ROS_AUTHOR = "Alexander W. Winkler"
HOMEPAGE = "http://github.com/leggedrobotics/xpp"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=24;endline=24;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "xpp"
ROS_BPN = "xpp_hyq"

ROS_BUILD_DEPENDS = " \
    roscpp \
    xacro \
    xpp-vis \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    xacro \
    xpp-vis \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    xacro \
    xpp-vis \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/leggedrobotics/xpp-release/archive/release/noetic/xpp_hyq/1.0.10-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/xpp_hyq"
SRC_URI = "git://github.com/leggedrobotics/xpp-release;${ROS_BRANCH};protocol=https"
SRCREV = "0e1e2d07eacf8b720823c22bbbb5eae3ae4de697"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
