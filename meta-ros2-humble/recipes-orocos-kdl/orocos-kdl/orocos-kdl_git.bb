LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8ffd58e6eb29a955738b8fcc9e9e8f2 \
                    file://debian/copyright;md5=57b48fd56cf39965622e7d8a9ff2ed50"

SRC_URI = "gitsm://github.com/orocos/orocos_kinematics_dynamics.git;protocol=https;branch=master \
           file://0001-CMakeLists.txt-fixing-install-location-of-cmake.patch \
           "

SRCREV = "db25b7e480e068df068232064f2443b8d52a83c7"

S = "${WORKDIR}/git/orocos_kdl"

DEPENDS = " \
    libeigen \
    boost \
"

inherit cmake

