# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_EXEC_DEPENDS_remove = "python-psutil"
ROS_EXEC_DEPENDS_append = " python3-psutil"

# ERROR: swri-prefix-tools-3.0.3-1-r0 do_package_qa: QA Issue: /usr/bin/xterm_prefix_normal contained in package swri-prefix-tools requires /bin/bash, but no providers found in RDEPENDS_swri-prefix-tools? [file-rdeps]
RDEPENDS_${PN} += "bash"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-dashing layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
