ROS_BUILD_DEPENDS += " \
    ${PYTHON_PN}-future-native \
"

# Doesn't inherit ros_catkin, only ros_cmake so we need to inherit right python*native here
inherit ${@'python3native' if d.getVar('ROS_PYTHON_VERSION', True) == '3' else 'pythonnative'}

# package.xml from this release says correctly LGPLv3:
# but the generated recipe has LGPL-2 which causes this warning:
# WARNING: mavlink-2020.2.2-1-r0 do_populate_lic: mavlink: No generic license file exists for: LGPL-2 in any provider
# because superflore regexp for parsing license information is very limited and
# doesn't support 'v' as license version separator:
# https://github.com/ros-infrastructure/superflore/blob/master/superflore/utils.py#L152
# see https://github.com/ros-infrastructure/superflore/issues/271
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('LGPL-2', 'LGPL-3.0')}"
