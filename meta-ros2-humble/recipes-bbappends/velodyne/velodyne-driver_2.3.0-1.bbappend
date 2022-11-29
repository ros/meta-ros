# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: velodyne-driver-2.3.0-1-r0 do_package_qa: QA Issue: /usr/lib/velodyne_driver/vdump contained in package velodyne-driver requires /bin/bash, but no providers found in RDEPENDS:velodyne-driver? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
