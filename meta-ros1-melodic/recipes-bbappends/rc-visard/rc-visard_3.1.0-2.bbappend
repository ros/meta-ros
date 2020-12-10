# Copyright (c) 2021 LG Electronics, Inc.

# rdepends on rc-visard-driver which depends on rc-genicam-api which has this restriction
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE_x86-64 = "(.*)"
COMPATIBLE_MACHINE_x86 = "(.*)"
COMPATIBLE_MACHINE_aarch64 = "(.*)"
COMPATIBLE_MACHINE_armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
COMPATIBLE_MACHINE_armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
