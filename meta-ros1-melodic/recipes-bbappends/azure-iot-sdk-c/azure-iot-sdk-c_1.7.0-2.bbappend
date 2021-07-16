# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-build-with-gcc-11.patch"

# ERROR: azure-iot-sdk-c-1.7.0-2-r0 do_package: QA Issue: azure-iot-sdk-c: Files/directories were installed but not shipped in any package:
#  /usr/cmake
#  /usr/cmake/azure_c_shared_utilityConfigVersion.cmake
#  .. 20 more ..
#  /usr/cmake/uamqpConfig.cmake
#  /usr/cmake/azure_c_shared_utilityTargets-noconfig.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# azure-iot-sdk-c: 24 installed and not shipped files. [installed-vs-shipped]
FILES:${PN}-dev += "${prefix}/cmake"
