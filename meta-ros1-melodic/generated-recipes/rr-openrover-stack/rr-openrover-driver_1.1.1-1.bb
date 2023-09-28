# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Provides an interface between ros and Rover Robotics rover hardware. Inputs to rr_openrover_driver     include emergency stop and velocity commands.  It outputs diagnostic data such as encoder     readings and battery charge."
AUTHOR = "Nick Padilla <nickpadilla@roverrobotics.com>"
ROS_AUTHOR = "Jack Kilian"
HOMEPAGE = "http://ros.org/wiki/rr_openrover_driver"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rr_openrover_stack"
ROS_BPN = "rr_openrover_driver"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    nav-msgs \
    roscpp \
    rospy \
    rr-openrover-driver-msgs \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    tf2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    joy \
    message-runtime \
    nav-msgs \
    roscpp \
    rospy \
    rr-openrover-driver-msgs \
    sensor-msgs \
    std-msgs \
    tf2 \
    twist-mux \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/RoverRobotics-release/rr_openrover_stack-release/archive/release/melodic/rr_openrover_driver/1.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rr_openrover_driver"
SRC_URI = "git://github.com/RoverRobotics-release/rr_openrover_stack-release;${ROS_BRANCH};protocol=https"
SRCREV = "e9215c5eea19b949c2143c8ca7582cdb81e8f6ed"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
