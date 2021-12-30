# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Marvelmind local navigation system"
AUTHOR = "smoker77 <smoker77@gmail.com>"
ROS_AUTHOR = "smoker77 <smoker77@gmail.com>"
HOMEPAGE = "http://marvelmind.com"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "marvelmind_nav"
ROS_BPN = "marvelmind_nav"

ROS_BUILD_DEPENDS = " \
    message-generation \
    roscpp \
    rospy \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    roscpp \
    rospy \
    std-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    roscpp \
    rospy \
    std-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/MarvelmindRobotics/marvelmind_nav-release/archive/release/noetic/marvelmind_nav/1.0.11-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/marvelmind_nav"
SRC_URI = "git://github.com/MarvelmindRobotics/marvelmind_nav-release;${ROS_BRANCH};protocol=https"
SRCREV = "a62c2fec22c3e9c41eebdfc893ea5842abf53aea"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}