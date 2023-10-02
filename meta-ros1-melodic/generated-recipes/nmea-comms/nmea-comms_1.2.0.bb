# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The nmea_comms package provides helper nodes for transmitting and receiving     the NMEA sentences."
AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
ROS_AUTHOR = "Mike Purvis <mpurvis@clearpathrobotics.com>"
HOMEPAGE = "http://wiki.ros.org/nmea_comms"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "nmea_comms"
ROS_BPN = "nmea_comms"

ROS_BUILD_DEPENDS = " \
    nmea-msgs \
    roscpp \
    roslaunch \
    roslint \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    nmea-msgs \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nmea-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-drivers-gbp/nmea_comms-release/archive/release/melodic/nmea_comms/1.2.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/nmea_comms"
SRC_URI = "git://github.com/ros-drivers-gbp/nmea_comms-release;${ROS_BRANCH};protocol=https"
SRCREV = "39473fe7bc6a093752245032dc40f1df05ce3708"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
