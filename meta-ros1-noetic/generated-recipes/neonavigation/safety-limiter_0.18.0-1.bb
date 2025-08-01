# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Motion limiter package for collision prevention"
AUTHOR = "Atsushi Watanabe <atsushi.w@ieee.org>"
ROS_AUTHOR = "Atsushi Watanabe <atsushi.w@ieee.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "neonavigation"
ROS_BPN = "safety_limiter"

ROS_BUILD_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    libeigen \
    neonavigation-common \
    pcl \
    pcl-conversions \
    pcl-ros \
    roscpp \
    safety-limiter-msgs \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    xmlrpcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    libeigen \
    neonavigation-common \
    pcl-conversions \
    pcl-ros \
    roscpp \
    safety-limiter-msgs \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    xmlrpcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    libeigen \
    neonavigation-common \
    pcl \
    pcl-conversions \
    pcl-ros \
    roscpp \
    safety-limiter-msgs \
    sensor-msgs \
    std-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    xmlrpcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    nav-msgs \
    roslint \
    rostest \
    tf2-geometry-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/at-wat/neonavigation-release/archive/release/noetic/safety_limiter/0.18.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/safety_limiter"
SRC_URI = "git://github.com/at-wat/neonavigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "36dd95c5733405e7caefa35ad12efd6c08180a74"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
