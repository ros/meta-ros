# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "python3-future-native"

inherit python3native

# package.xml from this release says correctly LGPLv3:
# https://github.com/mavlink/mavlink-gbp-release/blob/release/foxy/mavlink/2020.9.10-1/package.xml#L20
# but the generated recipe has LGPL-2 which causes this warning:
# WARNING: mavlink-2019.12.30-1-r0 do_populate_lic: mavlink: No generic license file exists for: LGPL-2 in any provider
# because superflore regexp for parsing license information is very limited and
# doesn't support 'v' as license version separator:
# https://github.com/ros-infrastructure/superflore/blob/master/superflore/utils.py#L152
LICENSE = "LGPL-3.0"
