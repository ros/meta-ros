ROS_BUILD_DEPENDS += " \
    ${PYTHON_PN}-pyyaml-native \
"

# package.xml from this release says correctly LGPLv3:
# but the generated recipe has LGPL-2 which causes this warning:
# WARNING: mavros-msgs-1.0.0-1-r0 do_populate_lic: mavros-msgs: No generic license file exists for: LGPL-2 in any provider
# because superflore regexp for parsing license information is very limited and
# doesn't support 'v' as license version separator:
# https://github.com/ros-infrastructure/superflore/blob/master/superflore/utils.py#L152
# see https://github.com/ros-infrastructure/superflore/issues/271
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('LGPL-2', 'LGPL-3.0')}"
