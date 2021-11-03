# Copyright (c) 2019 LG Electronics, Inc.

SECTION = "devel"
LICENSE = "ASL-1.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=79ba3a8bc4e89e76f90b0dadbf304749"

SRCREV = "5888464631094bb99ca211c8afb8e7f5b8235cbb"
SRC_URI = "git://github.com/awslabs/amazon-kinesis-video-streams-producer-sdk-cpp.git;protocol=https;branch=master"
S = "${WORKDIR}/git/${KVSSDK_PROJECT}"

inherit cmake
