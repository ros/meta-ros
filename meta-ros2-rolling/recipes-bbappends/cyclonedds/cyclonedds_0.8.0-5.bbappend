# Copyright (c) 2019-2021 LG Electronics, Inc.

# IDLC depends on maven and we don't want meta-ros to depend on meta-java just for that
EXTRA_OECMAKE += "-DBUILD_IDLC=OFF"

FILES:${PN}-dev += "${datadir}/CycloneDDS"

inherit ros_insane_dev_so

DEPENDS += "cyclonedds-native"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-ddsconf-install-ddsconf-to-be-used-in-target-cyclone.patch"
