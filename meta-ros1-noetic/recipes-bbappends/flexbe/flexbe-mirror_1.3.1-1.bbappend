# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: flexbe-mirror-1.3.1-1-r0 do_package_qa: QA Issue: /usr/opt/ros/noetic/lib/flexbe_mirror/behavior_mirror_sm contained in package flexbe-mirror requires /bin/bash, but no providers found in RDEPENDS:flexbe-mirror? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-noetic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
