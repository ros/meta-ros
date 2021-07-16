# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROSaic: C++ driver for Septentrio's mosaic receivers and beyond"
AUTHOR = "Septentrio <githubuser@septentrio.com>"
ROS_AUTHOR = "Tibor Dome"
HOMEPAGE = "https://github.com/septentrio-gnss/septentrio_gnss_driver"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD 3-Clause License"
LICENSE = "BSD-3-Clause-License"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "septentrio_gnss_driver"
ROS_BPN = "septentrio_gnss_driver"

ROS_BUILD_DEPENDS = " \
    boost \
    cpp-common \
    diagnostic-msgs \
    geometry-msgs \
    gps-common \
    message-generation \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    sensor-msgs \
    xmlrpcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    cpp-common \
    diagnostic-msgs \
    geometry-msgs \
    gps-common \
    message-runtime \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    sensor-msgs \
    xmlrpcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    cpp-common \
    diagnostic-msgs \
    geometry-msgs \
    gps-common \
    message-runtime \
    rosconsole \
    roscpp \
    roscpp-serialization \
    rostime \
    sensor-msgs \
    xmlrpcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/septentrio-users/septentrio_gnss_driver-release/archive/release/melodic/septentrio_gnss_driver/1.0.6-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/septentrio_gnss_driver"
SRC_URI = "git://github.com/septentrio-users/septentrio_gnss_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "4dbf87cfa1ada8826ee0ee5de9d720be82c33538"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
