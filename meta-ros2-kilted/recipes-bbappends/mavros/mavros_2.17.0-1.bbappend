# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: mavros-2.0.0-1-r0 do_package_qa: QA Issue: /usr/lib/mavros/install_geographiclib_datasets.sh contained in package mavros requires /bin/bash, but no providers found in RDEPENDS:mavros? [file-rdeps]
# ERROR: mavros-2.0.0-1-r0 do_package_qa: QA Issue: /usr/lib/mavros/mav contained in package mavros requires /usr/bin/python3, but no providers found in RDEPENDS:mavros? [file-rdeps]
ROS_EXEC_DEPENDS += " \
    bash \
    python3-core \
"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-foxy layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"

EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD=14"
