# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Fetch Simulation, packages for working with Fetch and Freight in Gazebo"
AUTHOR = "Alex Moriarty <amoriarty@fetchrobotics.com>"
ROS_AUTHOR = "Alex Moriarty <amoriarty@fetchrobotics.com>"
HOMEPAGE = "https://docs.fetchrobotics.com/gazebo.html"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fetch_gazebo"
ROS_BPN = "fetch_simulation"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fetch-gazebo \
    fetch-gazebo-demo \
    fetchit-challenge \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fetchrobotics-gbp/fetch_gazebo-release/archive/release/melodic/fetch_simulation/0.9.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/fetch_simulation"
SRC_URI = "git://github.com/fetchrobotics-gbp/fetch_gazebo-release;${ROS_BRANCH};protocol=https"
SRCREV = "587f5dd0e83e82c3841070be0a546200a0b200eb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
