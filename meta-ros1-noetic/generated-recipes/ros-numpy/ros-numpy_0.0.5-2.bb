# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A collection of conversion function for extracting numpy arrays from messages"
AUTHOR = "Eric Wieser <wieser@mit.edu>"
ROS_AUTHOR = "Eric Wieser <wieser@mit.edu>"
HOMEPAGE = "http://wiki.ros.org/ros_numpy"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "ros_numpy"
ROS_BPN = "ros_numpy"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    nav-msgs \
    python3-numpy \
    rospy \
    sensor-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/eric-wieser/ros_numpy-release/archive/release/noetic/ros_numpy/0.0.5-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ros_numpy"
SRC_URI = "git://github.com/eric-wieser/ros_numpy-release;${ROS_BRANCH};protocol=https"
SRCREV = "c301ac4d22e94438f2ae1e76d528cd8ab07377d7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
