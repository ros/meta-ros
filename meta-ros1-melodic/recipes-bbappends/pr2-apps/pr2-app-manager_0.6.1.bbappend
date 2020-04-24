# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: pr2-app-manager-0.6.1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/pr2_app_manager/install_applications.sh contained in package pr2-app-manager requires /bin/bash, but no providers found in RDEPENDS_pr2-app-manager? [file-rdeps]
RDEPENDS_${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
