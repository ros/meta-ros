# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-typo-when-searching-for-Python-In.patch"
SRC_URI += "file://0002-mavgenerate.py-pymavlink-use-python3.patch"

DEPENDS += "python3-future-native"

inherit python3native

# package.xml from this release says correctly LGPLv3:
# https://github.com/mavlink/mavlink-gbp-release/blob/release/eloquent/mavlink/2019.12.30-1/package.xml#L20
# but the generated recipe has LGPL-2 which causes this warning:
# WARNING: mavlink-2019.12.30-1-r0 do_populate_lic: mavlink: No generic license file exists for: LGPL-2 in any provider
# because superflore regexp for parsing license information is very limited and
# doesn't support 'v' as license version separator:
# https://github.com/ros-infrastructure/superflore/blob/master/superflore/utils.py#L152
LICENSE = "LGPL-3.0"
