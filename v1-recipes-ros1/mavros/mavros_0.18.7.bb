DESCRIPTION = "MAVROS -- MAVLink extendable communication node for ROS with \
proxy for Ground Control Station."
LICENSE = "BSD | GPLv3 | LGPLv3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=14;md5=9b511d4c606b1a23e454d3260818d003"

# System dependencies

DEPENDS = " \
    boost \
    libeigen \
    mavlink \
"

RDEPENDS_${PN} = " \
    boost \
    mavlink \
"

# ROS packages dependencies
MAVROS_RUN_AND_BUILD_DEPENDS = " \
    diagnostic-updater \
    eigen-conversions \
    libmavconn \
    pluginlib \
    rosconsole-bridge \
    roscpp \
    tf2-ros \
    diagnostic-msgs \
    geometry-msgs \
    mavros-msgs \
    nav-msgs \
    sensor-msgs \
    std-msgs \
    std-srvs \
"

DEPENDS_append = " \
    angles \
    cmake-modules \
    message-runtime \
    rospy \
    ${MAVROS_RUN_AND_BUILD_DEPENDS} \
"

RDEPENDS_${PN}_append = "${MAVROS_RUN_AND_BUILD_DEPENDS}"

require mavros.inc

ROS_PKG_SUBDIR = "mavros"

SRC_URI += "file://0001-always-find-Eigen-with-cmake_modules-mechanism.patch;striplevel=2 \
            file://0001-CMake-explicitly-link-the-atomic-library-797.patch;striplevel=2"
