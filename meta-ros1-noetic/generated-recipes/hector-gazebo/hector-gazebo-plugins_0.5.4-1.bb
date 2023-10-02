# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "hector_gazebo_plugins provides gazebo plugins from Team Hector.      Currently it contains a 6wd differential drive plugin, an IMU sensor plugin,      an earth magnetic field sensor plugin, a GPS sensor plugin and a      sonar ranger plugin."
AUTHOR = "Stefan Fabian <fabian@sim.tu-darmstadt.de>"
ROS_AUTHOR = "Stefan Kohlbrecher <kohlbrecher@sim.tu-darmstadt.de>"
HOMEPAGE = "http://ros.org/wiki/hector_gazebo_plugins"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "hector_gazebo"
ROS_BPN = "hector_gazebo_plugins"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    gazebo-rosdev \
    geographic-msgs \
    geometry-msgs \
    message-generation \
    nav-msgs \
    roscpp \
    std-msgs \
    std-srvs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-gazebo} \
    dynamic-reconfigure \
    gazebo-ros \
    geographic-msgs \
    geometry-msgs \
    message-runtime \
    nav-msgs \
    roscpp \
    std-msgs \
    std-srvs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tu-darmstadt-ros-pkg-gbp/hector_gazebo-release/archive/release/noetic/hector_gazebo_plugins/0.5.4-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/hector_gazebo_plugins"
SRC_URI = "git://github.com/tu-darmstadt-ros-pkg-gbp/hector_gazebo-release;${ROS_BRANCH};protocol=https"
SRCREV = "ee08cb9b9ededc906088c19ac546d15bc473f67c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
