# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: yocs-ar-pair-approach-0.8.2-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/yocs_ar_pair_approach/enable_service contained in package yocs-ar-pair-approach requires /bin/bash, but no providers found in RDEPENDS:yocs-ar-pair-approach? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
