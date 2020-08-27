# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += " \
    amazon-kvs-sdk-cpp-kinesis-video-native-build \
    amazon-kvs-sdk-cpp-kinesis-video-producer \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-don-t-build-and-install-kvssdk.patch \
    file://0001-Link-libraries-only-if-test-targets-exist-36.patch \
"

EXTRA_OECMAKE = "-DKVSSDK_EXTERNAL_LIB_DIR=${STAGING_DIR_HOST}${libdir} \
    -DKVSSDK_EXTERNAL_INCLUDE_DIR=${STAGING_DIR_HOST}${includedir} \
"
