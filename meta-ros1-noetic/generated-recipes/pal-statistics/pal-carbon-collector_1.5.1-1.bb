# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Node that collects statistics from topics and sends them to carbon"
AUTHOR = "Jordan Palacios <jordan.palacios@pal-robotics.com>"
ROS_AUTHOR = "Jordan Palacios <jordan.palacios@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "pal_statistics"
ROS_BPN = "pal_carbon_collector"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    pal-statistics-msgs \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pal-gbp/pal_statistics-release/archive/release/noetic/pal_carbon_collector/1.5.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/pal_carbon_collector"
SRC_URI = "git://github.com/pal-gbp/pal_statistics-release;${ROS_BRANCH};protocol=https"
SRCREV = "27b02aa57292c040b8f596b93ad612d95e51f861"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
