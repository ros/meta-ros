# Copyright (c) 2019 LG Electronics, Inc.

require amazon-kvs-sdk-cpp-${PV}.inc

KVSSDK_PROJECT = "kinesis-video-native-build"

DEPENDS = "log4cplus openssl curl"

# There is no install target in CMake, only scripts like install-script, install-script-ami, install-script-common.sh, min-install-script
# kinesis-manager uses ExternalProject with min-install-script call, but needs only the libproducer.so, lets install just that
do_install() {
    install -Dm 0644 ${B}/libproducer.so ${D}${libdir}/libproducer.so
}

# ERROR: amazon-kvs-sdk-cpp-kinesis-video-native-build-1.7.8-r0 do_package_qa: QA Issue: -dev package contains non-symlink .so: amazon-kvs-sdk-cpp-kinesis-video-native-build-dev path '/work/i586-oe-linux/amazon-kvs-sdk-cpp-kinesis-video-native-build/1.7.8-r0/packages-split/amazon-kvs-sdk-cpp-kinesis-video-native-build-dev/usr/lib/libproducer.so' [dev-elf]
inherit ros_faulty_solibs
