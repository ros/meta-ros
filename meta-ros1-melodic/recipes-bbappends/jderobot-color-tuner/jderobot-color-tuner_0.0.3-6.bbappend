# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: jderobot-color-tuner-0.0.3-6-r0 do_package_qa: QA Issue: /opt/ros/melodic/bin/colorTuner contained in package jderobot-color-tuner requires /bin/bash, but no providers found in RDEPENDS_jderobot-color-tuner? [file-rdeps]
ROS_EXEC_DEPENDS += " \
    bash \
"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
