# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: quanergy-client-5.0.0-1-r0 do_package: QA Issue: quanergy-client: Files/directories were installed but not shipped in any package:
#   /usr/share/QuanergyClient
#   /usr/share/QuanergyClient/QuanergyClientConfig.cmake
#   /usr/share/QuanergyClient/QuanergyClientTargets-noconfig.cmake
#   /usr/share/QuanergyClient/QuanergyClientConfigVersion.cmake
#   /usr/share/QuanergyClient/QuanergyClientTargets.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# quanergy-client: 5 installed and not shipped files. [installed-vs-shipped]
FILES:${PN}-dev += "${datadir}/QuanergyClient"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-don-t-make-INSTALL_-_DIR-variables-to.patch"
