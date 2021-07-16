# Copyright (c) 2021 LG Electronics, Inc.

# depends on rc-genicam-api which has this restriction
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
COMPATIBLE_MACHINE:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"

# RC_PROJECT_VERSION is set in cmake/project_version.cmake by git describe checking for 'v?([0-9.]+).*' tag
# but in roboception-gbp/rc_visard-release repo there are no suitable tags:
# rc-visard-driver/3.0.4-1-r0/git$ git describe --all
# gs/release/melodic/rc_visard_driver/3.0.4-1
# so it ends 0.0.0 triggering an warning:
# -- PACKAGE_XML_VERSION: 3.0.4
# CMake Warning at cmake/project_version.cmake:124 (message):
#   Version from package.xml (3.0.4) doesn't match RC_PROJECT_VERSION (0.0.0)
# Call Stack (most recent call first):
#   CMakeLists.txt:4 (include)
RC_PROJECT_VERSION = "${@'${PV}'.split('-')[0]}"

EXTRA_OECMAKE += "-DRC_PROJECT_VERSION=${RC_PROJECT_VERSION}"
