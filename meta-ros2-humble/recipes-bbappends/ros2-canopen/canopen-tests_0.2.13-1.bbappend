# Copyright (c) 2025 Wind River Systems, Inc.

DEPENDS += "lely-core-libraries-native"

FILESEXTRAPATHS:prepend := "${THISDIR}/canopen-tests:"
SRC_URI += "file://0001-Add-missing-torque-actual-value-object-0x6077.patch"

# cogen is located in /opt/ros/<DISTRO>/bin
do_compile:prepend:class-target() {
    export PATH=${STAGING_DIR_NATIVE}${ros_bindir}:$PATH
}
