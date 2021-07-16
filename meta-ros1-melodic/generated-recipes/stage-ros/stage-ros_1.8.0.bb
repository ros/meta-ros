# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package provides ROS specific hooks for stage"
AUTHOR = "William Woodall <william@osrfoundation.org>"
ROS_AUTHOR = "Brian Gerky <gerky@osrfoundation.org>"
HOMEPAGE = "http://ros.org/wiki/stage_ros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "stage_ros"
ROS_BPN = "stage_ros"

ROS_BUILD_DEPENDS = " \
    boost \
    geometry-msgs \
    nav-msgs \
    roscpp \
    rostest \
    sensor-msgs \
    stage \
    std-msgs \
    std-srvs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    geometry-msgs \
    nav-msgs \
    roscpp \
    sensor-msgs \
    stage \
    std-msgs \
    std-srvs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    geometry-msgs \
    nav-msgs \
    roscpp \
    sensor-msgs \
    stage \
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

# matches with: https://github.com/ros-gbp/stage_ros-release/archive/release/melodic/stage_ros/1.8.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/stage_ros"
SRC_URI = "git://github.com/ros-gbp/stage_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "22b36675a517a1817a52021012608953532a260d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
