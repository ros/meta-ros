# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The um6 package provides a C++ implementation of the CH Robotics serial protocol, and a     corresponding ROS node for publishing standard ROS orientation topics from a UM6."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
ROS_AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "um6"
ROS_BPN = "um6"

ROS_BUILD_DEPENDS = " \
    message-generation \
    roscpp \
    roslint \
    sensor-msgs \
    serial \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    roscpp \
    sensor-msgs \
    serial \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    roscpp \
    sensor-msgs \
    serial \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/um6-release/archive/release/melodic/um6/1.1.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/um6"
SRC_URI = "git://github.com/ros-drivers-gbp/um6-release;${ROS_BRANCH};protocol=https"
SRCREV = "aa170ff62fc4e61acae3d25c64772bedfb6704c2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
