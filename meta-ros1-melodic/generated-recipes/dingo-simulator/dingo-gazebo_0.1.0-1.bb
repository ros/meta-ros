# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Launchfiles to use Dingo in Gazebo."
AUTHOR = "Tony Baltovski <tbaltovski@clearpathrobotics.com>"
ROS_AUTHOR = "Tony Baltovski"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "dingo_simulator"
ROS_BPN = "dingo_gazebo"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dingo-control \
    dingo-description \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    hector-gazebo-plugins \
    ridgeback-gazebo-plugins \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/clearpath-gbp/dingo_simulator-release/archive/release/melodic/dingo_gazebo/0.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/dingo_gazebo"
SRC_URI = "git://github.com/clearpath-gbp/dingo_simulator-release;${ROS_BRANCH};protocol=https"
SRCREV = "8a46985e94178257e83010dc47d0f696609aae27"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
