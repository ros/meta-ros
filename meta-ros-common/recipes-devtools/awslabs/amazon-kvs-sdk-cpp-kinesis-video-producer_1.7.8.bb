# Copyright (c) 2019 LG Electronics, Inc.

require amazon-kvs-sdk-cpp-${PV}.inc

KVSSDK_PROJECT = "kinesis-video-producer"

DEPENDS = "curl jsoncpp log4cplus openssl amazon-kvs-sdk-cpp-kinesis-video-pic"

SRC_URI += "file://0001-kinesis-video-producer-fix-include-paths.patch;patchdir=.. \
    file://0001-kinesis-video-producer-don-t-build-tst-subdirectory-.patch;patchdir=.. \
"

# kinesis-manager expects kinesis-video-producer header files to be in kinesis-video-producer subdirectory
# | /jenkins/mjansa/build-ros/ros2-dashing-thud/tmp-glibc/work/i586-oe-linux/kinesis-manager/2.0.1-1-r0/git/src/kinesis_stream_manager.cpp:19:10: fatal error: kinesis-video-producer/ClientCallbackProvider.h: No such file or directory
# |  #include <kinesis-video-producer/ClientCallbackProvider.h>
do_install_append() {
    install -d ${D}${includedir}/kinesis-video-producer
    mv ${D}${includedir}/*.h ${D}${includedir}/kinesis-video-producer/
}

# ERROR: amazon-kvs-sdk-cpp-kinesis-video-producer-1.7.8-r0 do_package_qa: QA Issue: -dev package contains non-symlink .so: amazon-kvs-sdk-cpp-kinesis-video-producer-dev path '/work/i586-oe-linux/amazon-kvs-sdk-cpp-kinesis-video-producer/1.7.8-r0/packages-split/amazon-kvs-sdk-cpp-kinesis-video-producer-dev/usr/lib/libKinesisVideoProducer.so' [dev-elf]
inherit ros_faulty_solibs
