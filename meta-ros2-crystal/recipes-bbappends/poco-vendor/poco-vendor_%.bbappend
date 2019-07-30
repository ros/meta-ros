# Copyright (c) 2019 LG Electronics, Inc.

# superflore maps "Boost Software License 1.0" to "Boost-1.0", which is what Gentoo expects, but it's non-standard.
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('Boost-', 'BSL-')}"

ALLOW_EMPTY_${PN} = "1"
