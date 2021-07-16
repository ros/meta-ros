# Copyright (c) 2021 LG Electronics, Inc.

# rdepends on rc-visard-driver which depends on rc-genicam-api which has this restriction
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
COMPATIBLE_MACHINE:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
