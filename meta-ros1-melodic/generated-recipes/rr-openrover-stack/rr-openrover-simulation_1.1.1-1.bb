# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The rr_openrover_simulation package"
AUTHOR = "Nick Padilla <nickpadilla@roverrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "rr_openrover_stack"
ROS_BPN = "rr_openrover_simulation"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-msgs \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    gazebo-ros-pkgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/RoverRobotics-release/rr_openrover_stack-release/archive/release/melodic/rr_openrover_simulation/1.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rr_openrover_simulation"
SRC_URI = "git://github.com/RoverRobotics-release/rr_openrover_stack-release;${ROS_BRANCH};protocol=https"
SRCREV = "f4ac139742f74b5e4b1ddaabaa3a96f72cf4ee57"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
