# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The laser_scan_densifier takes in a LaserScan message and densifies it.     Node is inspired by laser_scan_sparsifier (http://wiki.ros.org/laser_scan_sparsifier)."
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "cob_driver"
ROS_BPN = "laser_scan_densifier"

ROS_BUILD_DEPENDS = " \
    nodelet \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    nodelet \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    nodelet \
    roscpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/4am-robotics/cob_driver-release/archive/release/noetic/laser_scan_densifier/0.7.17-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/laser_scan_densifier"
SRC_URI = "git://github.com/4am-robotics/cob_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "21394f36efadb8900d6d4b0f25cc72320aefa4f1"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
