# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: cob-safety-controller-0.6.10-1-r0 do_package_qa: QA Issue: /usr/opt/ros/noetic/lib/cob_safety_controller/safety_controller contained in package cob-safety-controller requires /bin/bash, but no providers found in RDEPENDS:cob-safety-controller? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-noetic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
