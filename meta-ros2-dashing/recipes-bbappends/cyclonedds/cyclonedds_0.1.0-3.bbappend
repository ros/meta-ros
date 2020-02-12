# Copyright (c) 2019 LG Electronics, Inc.

# IDLC depends on maven and we don't want meta-ros to depend on meta-java just for that
EXTRA_OECMAKE += "-DBUILD_IDLC=OFF"

FILES_${PN}-dev += "${datadir}/CycloneDDS"

inherit ros_insane_dev_so

# Use SPDX name of the license
LICENSE_remove = "Eclipse-Public-License-2.0"
LICENSE += "EPL-2.0"
