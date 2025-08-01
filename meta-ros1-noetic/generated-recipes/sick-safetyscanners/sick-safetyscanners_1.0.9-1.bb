# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Provides an Interface to read the sensor output of a SICK   Safety Scanner"
AUTHOR = "Lennart Puck <puck@fzi.de>"
ROS_AUTHOR = "Lennart Puck"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "ALv2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=48a602c865794401f5c0c56e309d9596"

ROS_CN = "sick_safetyscanners"
ROS_BPN = "sick_safetyscanners"

ROS_BUILD_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    message-generation \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    message-runtime \
    roscpp \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SICKAG/sick_safetyscanners-release/archive/release/noetic/sick_safetyscanners/1.0.9-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/sick_safetyscanners"
SRC_URI = "git://github.com/SICKAG/sick_safetyscanners-release;${ROS_BRANCH};protocol=https"
SRCREV = "51e116dd70199dd62e2a60cc0b1b4e38f6579b2c"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
