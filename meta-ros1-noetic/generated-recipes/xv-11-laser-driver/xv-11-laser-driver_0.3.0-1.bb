# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Neato XV-11 Laser Driver. This driver works with the laser when it is removed from the XV-11 Robot as opposed to reading scans from the Neato's USB port."
AUTHOR = "rohan <send2arohan@gmail.com>"
ROS_AUTHOR = "Eric Perko"
HOMEPAGE = "http://ros.org/wiki/xv_11_laser_driver"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "xv_11_laser_driver"
ROS_BPN = "xv_11_laser_driver"

ROS_BUILD_DEPENDS = " \
    roscpp \
    sensor-msgs \
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

# matches with: https://github.com/rohbotics/xv_11_laser_driver-release/archive/release/noetic/xv_11_laser_driver/0.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/xv_11_laser_driver"
SRC_URI = "git://github.com/rohbotics/xv_11_laser_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "af3ac1af48cbb81d68eb65fbe4f6749e2ed16ba3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
