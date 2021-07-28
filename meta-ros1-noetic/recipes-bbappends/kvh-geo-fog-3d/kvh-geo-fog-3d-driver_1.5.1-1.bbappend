# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: kvh-geo-fog-3d-driver-1.3.3-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/share/kvh_geo_fog_3d_driver/run_tests.sh contained in package kvh-geo-fog-3d-driver requires /bin/bash, but no providers found in RDEPENDS_kvh-geo-fog-3d-driver? [file-rdeps]
RDEPENDS_${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"

# Fails with webOS OSE which by default uses -Werror=return-type
# kvh-geo-fog-3d-driver/1.3.3-1-r0/git/src/kvh_driver/driver_main.cpp:310:3: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-build-with-gcc-10.patch"
