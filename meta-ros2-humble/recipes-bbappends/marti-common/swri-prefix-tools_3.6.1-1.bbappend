# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: swri-prefix-tools-3.3.2-2-r0 do_package_qa: QA Issue: /usr/bin/xterm_prefix_normal contained in package swri-prefix-tools requires /bin/bash, but no providers found in RDEPENDS:swri-prefix-tools? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-dashing layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
