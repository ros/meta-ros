# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0 & Artistic-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://src/systems/elevator/vender/afsm/LICENSE;md5=ec4341a201f4b801aba0191a5d2d8f39 \
                    file://src/systems/elevator/vender/metapushkin/LICENSE;md5=ec4341a201f4b801aba0191a5d2d8f39"

SRC_URI = "git://github.com/gazebosim/gz-sim.git;protocol=https;branch=ign-gazebo6"

SRCREV = "326cef2b4a177bf6ea957fe9e2841c4719d598db"

S = "${WORKDIR}/git"

inherit cmake python3-dir

DEPENDS = " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-fuel-tools7 \
    ignition-gui6 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-physics5 \
    ignition-plugin \
    ignition-rendering6 \
    ignition-sensors6 \
    ignition-tools1 \
    ignition-transport11 \
    ignition-utils1 \
    sdformat \
"

RPROVIDES:${PN} += " gazebo"
