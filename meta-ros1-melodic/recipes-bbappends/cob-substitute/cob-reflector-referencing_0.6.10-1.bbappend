# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: cob-reflector-referencing-0.6.9-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/cob_reflector_referencing/reflector_referencing_node contained in package cob-reflector-referencing requires /bin/bash, but no providers found in RDEPENDS:cob-reflector-referencing? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
