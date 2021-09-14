# Copyright (c) 2021 LG Electronics, Inc.

# pmb2-2dnav-3.0.1-1-r0 do_package_qa: QA Issue: /usr/lib/pmb2_2dnav/record_rgbd.sh contained in package pmb2-2dnav requires /bin/bash, but no providers found in RDEPENDS:pmb2-2dnav? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-foxy layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
