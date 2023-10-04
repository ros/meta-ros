# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

LICENSE = "EPL-2.0 & EDL-1.0"

# IDLC depends on maven and we don't want meta-ros to depend on meta-java just for that
inherit ros_insane_dev_so

EXTRA_OECMAKE += "-DBUILD_IDLC=OFF"
FILES:${PN}-dev += "${datadir}/CycloneDDS"
DEPENDS += "cyclonedds-native"

#  re-do configuration manually
#
do_configure:append:class-native() {
    rm -r ${WORKDIR}/build/*
    cmake -G Ninja ${WORKDIR}/git
}

# FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-ddsconf-install-ddsconf-to-be-used-in-target-cyclone.patch"
