# geographiclib-tools is just a package from geographiclib recipe it should be in
# RDEPENDS not DEPENDS
ROS_EXEC_DEPENDS += "geographiclib-tools"

# ERROR: mavros-1.0.0-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/mavros/install_geographiclib_datasets.sh contained in package mavros requires /bin/bash, but no providers found in RDEPENDS_mavros? [file-rdeps]
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

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-ftf_frame_convertions.cpp-work-around-few-return-typ.patch"
