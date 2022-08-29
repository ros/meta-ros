# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-build-with-gcc-11.patch"

# ERROR: azure-iot-sdk-c-1.7.0-4-r0 do_package: QA Issue: azure-iot-sdk-c: Files/directories were installed but not shipped in any package:
#  /usr/cmake
#  /usr/cmake/azure_c_shared_utilityConfigVersion.cmake
#  .. 20 more ..
#  /usr/cmake/uamqpConfig.cmake
#  /usr/cmake/azure_c_shared_utilityTargets-noconfig.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# azure-iot-sdk-c: 24 installed and not shipped files. [installed-vs-shipped]
FILES:${PN}-dev += "${prefix}/cmake"

# Not compatible with openssl-3
PACKAGECONFIG ??= "wolfssl"
PACKAGECONFIG[openssl] = "-Duse_openssl:BOOL=ON,-Duse_openssl:BOOL=OFF,openssl"
PACKAGECONFIG[wolfssl] = "-Duse_wolfssl:BOOL=ON,-Duse_wolfssl:BOOL=OFF,wolfssl"
PACKAGECONFIG[mbedtls] = "-Duse_mbedtls:BOOL=ON,-Duse_mbedtls:BOOL=OFF,mbedtls"
PACKAGECONFIG[bearssl] = "-Duse_bearssl:BOOL=ON,-Duse_bearssl:BOOL=OFF,bearssl"
PACKAGECONFIG[c-ares] = "-Duse_c_ares:BOOL=ON,-Duse_c_ares:BOOL=OFF,c-ares"
