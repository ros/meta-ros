# geographiclib-tools is just a package from geographiclib recipe it should be in
# RDEPENDS not DEPENDS
ROS_BUILD_DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_geographiclib-tools}"
ROS_EXPORT_DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_geographiclib-tools}"
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

# package.xml from this release says correctly LGPLv3:
# but the generated recipe has LGPL-2 which causes this warning:
# WARNING: mavros-1.0.0-1-r0 do_populate_lic: mavros: No generic license file exists for: LGPL-2 in any provider
# because superflore regexp for parsing license information is very limited and
# doesn't support 'v' as license version separator:
# https://github.com/ros-infrastructure/superflore/blob/master/superflore/utils.py#L152
# see https://github.com/ros-infrastructure/superflore/issues/271
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('LGPL-2', 'LGPL-3.0')}"
