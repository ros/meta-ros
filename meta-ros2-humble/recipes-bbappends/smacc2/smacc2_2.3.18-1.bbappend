# Copyright (c) 2021 LG Electronics, Inc.

# smacc2-0.1.0-1-r0 do_package_qa: QA Issue: /usr/lib/smacc2/trace.sh contained in package smacc2 requires /bin/bash, but no providers found in RDEPENDS:smacc2? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-rolling layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-ISmaccStateMachine-getCurrentStateCounter-return.patch"
