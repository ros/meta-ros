# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Python and C++ interfaces for manipulating geodetic coordinates."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://wiki.ros.org/geodesy"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "geographic_info"
ROS_BPN = "geodesy"

ROS_BUILD_DEPENDS = " \
    angles \
    geographic-msgs \
    geometry-msgs \
    python3-catkin-pkg \
    python3-pyproj \
    sensor-msgs \
    unique-identifier-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    geographic-msgs \
    geometry-msgs \
    python3-pyproj \
    sensor-msgs \
    unique-identifier-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    geographic-msgs \
    geometry-msgs \
    python3-pyproj \
    sensor-msgs \
    unique-identifier-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/geographic_info-release/archive/release/rolling/geodesy/1.0.4-4.tar.gz
ROS_BRANCH ?= "branch=release/rolling/geodesy"
SRC_URI = "git://github.com/ros2-gbp/geographic_info-release;${ROS_BRANCH};protocol=https"
SRCREV = "f90e768690175175a5ddc1d9531d04f6b6b2d906"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
