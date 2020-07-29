# Copyright (c) 2019-2020 LG Electronics, Inc.

# IDLC depends on maven and we don't want meta-ros to depend on meta-java just for that
EXTRA_OECMAKE += "-DBUILD_IDLC=OFF"

FILES_${PN}-dev += "${datadir}/CycloneDDS"

inherit ros_insane_dev_so

BBCLASSEXTEND = "native"

# Use SPDX name of the license
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('Eclipse-Public-License-2.0', 'EPL-2.0')}"
