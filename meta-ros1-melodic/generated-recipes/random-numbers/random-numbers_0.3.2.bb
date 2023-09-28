# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This  library contains wrappers for generating floating point values, integers, quaternions using boost libraries.    The constructor of the wrapper is guaranteed to be thread safe and initialize its random number generator to a random seed.   Seeds are obtained using a separate and different random number generator."
AUTHOR = "Steven! Ragnarök <stevenragnarok@osrfoundation.org>"
ROS_AUTHOR = "Ioan Sucan <isucan@willowgarage.edu>"
HOMEPAGE = "http://ros.org/wiki/random_numbers"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "random_numbers"
ROS_BPN = "random_numbers"

ROS_BUILD_DEPENDS = " \
    boost \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/random_numbers-release/archive/release/melodic/random_numbers/0.3.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/random_numbers"
SRC_URI = "git://github.com/ros-gbp/random_numbers-release;${ROS_BRANCH};protocol=https"
SRCREV = "bee7dd844f3393fcfa04c5dc26dcb18dec966bb8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
