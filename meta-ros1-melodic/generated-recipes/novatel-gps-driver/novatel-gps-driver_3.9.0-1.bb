# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Driver for NovAtel receivers"
AUTHOR = "P. J. Reed <preed@swri.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "novatel_gps_driver"
ROS_BPN = "novatel_gps_driver"

ROS_BUILD_DEPENDS = " \
    boost \
    diagnostic-msgs \
    diagnostic-updater \
    gps-common \
    libpcap \
    nav-msgs \
    nodelet \
    novatel-gps-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    swri-math-util \
    swri-nodelet \
    swri-roscpp \
    swri-serial-util \
    swri-string-util \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    diagnostic-msgs \
    diagnostic-updater \
    gps-common \
    libpcap \
    nav-msgs \
    nodelet \
    novatel-gps-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    swri-math-util \
    swri-nodelet \
    swri-roscpp \
    swri-serial-util \
    swri-string-util \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    diagnostic-msgs \
    diagnostic-updater \
    gps-common \
    libpcap \
    nav-msgs \
    nodelet \
    novatel-gps-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    swri-math-util \
    swri-nodelet \
    swri-roscpp \
    swri-serial-util \
    swri-string-util \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/swri-robotics-gbp/novatel_gps_driver-release/archive/release/melodic/novatel_gps_driver/3.9.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/novatel_gps_driver"
SRC_URI = "git://github.com/swri-robotics-gbp/novatel_gps_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "fab3371440e2860aa4312daf24341c631541eeaf"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
