# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "ROS 1 node for the Raspberry Pi Camera Module"
HOMEPAGE = "https://github.com/UbiquityRobotics/raspicam_node"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3045e9d5326c8f5c311a93f8a9abb873"

PV = "1.2+git${SRCPV}"

SRCREV = "195694afee514370aaf28712e1e09c48bdaf2af7"
SRC_URI = "git://github.com/UbiquityRobotics/raspicam_node;protocol=https;branch=kinetic"
S = "${WORKDIR}/git"

inherit ros1_distro
inherit ros_component
inherit ros_catkin

# From package.xml, except "userland" is used instead of "libraspberrypi0".
DEPENDS = " \
    compressed-image-transport \
    diagnostic-updater \
    dynamic-reconfigure \
    message-generation \
    roscpp \
    std-srvs \
    sensor-msgs \
    userland \
"
# Missing from package.xml:
DEPENDS += " \
    ${PYTHON_PN}-empy-native \
    camera-info-manager \
    ${PYTHON_PN}-catkin-pkg-native \
"

RDEPENDS_${PN} = "message-runtime"

COMPATIBLE_MACHINE = "^rpi$"

# aarch64 userland doesn't provide mmal needed by raspicam-node
COMPATIBLE_MACHINE_aarch64 = "^$"
