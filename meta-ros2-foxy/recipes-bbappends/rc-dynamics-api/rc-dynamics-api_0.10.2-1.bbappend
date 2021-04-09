# Copyright (c) 2021 LG Electronics, Inc.

# it tries to run js_embed and fails with:
# /bin/sh: js_embed: command not found
# because it does depend only on target protobuf, not protobuf-native:
DEPENDS += "protobuf-native"

# ERROR: rc-dynamics-api-0.10.3-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: rc-dynamics-api path '/work/core2-64-oe-linux/rc-dynamics-api/0.10.3-1-r0/packages-split/rc-dynamics-api/usr/lib/librc_dynamics_api.so' [dev-so]
inherit ros_insane_dev_so

# RC_PROJECT_VERSION is set in cmake/project_version.cmake by git describe checking for 'v?([0-9.]+).*' tag
# but in roboception-gbp/rc_dynamics_api-release repo there are no suitable tags:
# rc-dynamics-api/0.10.2-1-r0/git$ git describe --all
# tags/release/foxy/rc_dynamics_api/0.10.2-1
# so it ends 0.0.0 triggering an warning:
# -- PACKAGE_XML_VERSION: 0.10.2
# CMake Warning at cmake/project_version.cmake:115 (message):
#   PACKAGE_VERSION not set! Falling back to RC_PROJECT_VERSION (0.0.0)
# Call Stack (most recent call first):
#   CMakeLists.txt:38 (include)
# and then more importantly rc-visard-driver error:
# CMake Error at CMakeLists.txt:58 (find_package):
#  Could not find a configuration file for package "RC_DYNAMICS_API" that is
#  compatible with requested version "0.8".
#
#  The following configuration files were considered but not accepted:
#
#    TOPDIR/tmp-glibc/work/qemux86-webos-linux/rc-visard-driver/3.0.4-1-r0/recipe-sysroot/usr/lib/rc_dynamics_api/RC_DYNAMICS_APIConfig.cmake, version: 0.0.0
RC_PROJECT_VERSION = "${@'${PV}'.split('-')[0]}"

EXTRA_OECMAKE += "-DRC_PROJECT_VERSION=${RC_PROJECT_VERSION}"
