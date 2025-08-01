# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_kilted
inherit ros_superflore_generated

DESCRIPTION = "Package to parse NMEA strings and publish a very simple GPS message. Does not         require or use the GPSD deamon."
AUTHOR = "Ed Venator <evenator@gmail.com>"
ROS_AUTHOR = "Eric Perko <eric@ericperko.com>"
HOMEPAGE = "http://ros.org/wiki/nmea_navsat_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=01c2bc31767ccb3a68e12f02612b2a97"

ROS_CN = "nmea_navsat_driver"
ROS_BPN = "nmea_navsat_driver"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    nmea-msgs \
    python3-numpy \
    python3-pyserial \
    rclpy \
    sensor-msgs \
    tf-transformations \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/nmea_navsat_driver-release/archive/release/kilted/nmea_navsat_driver/2.0.1-3.tar.gz
ROS_BRANCH ?= "branch=release/kilted/nmea_navsat_driver"
SRC_URI = "git://github.com/ros2-gbp/nmea_navsat_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "b15d2cec3124c59659d547936c3970ddd025589b"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
