# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "aws-cpp-sdk component - ${BPN}"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e \
    file://LICENSE.txt;md5=e0a34bbbe8370ca4767991e22fc3fda8 \
"

PV = "1.6.53+git${SRCPV}"

SRCREV = "59337ec3dd6a998bddb41e4bad39e783cad34b6b"
SRC_URI = "git://github.com/aws/aws-sdk-cpp.git;protocol=https"
S = "${WORKDIR}/git"

inherit cmake ros_faulty_solibs

DEPENDS += "aws-c-common aws-c-event-stream aws-checksums curl openssl zlib"

# Build only what is needed for aws-common
# other components need more dependencies like pulseaudio etc
BUILD_COMPONENTS="core;logs;monitoring;s3;kinesis;iot;lex;polly"

EXTRA_OECMAKE += "-DBUILD_DEPS=OFF -DBUILD_SHARED_LIBS=ON -DBUILD_ONLY='${BUILD_COMPONENTS}'"
EXTRA_OECMAKE += "-DCURL_HAS_H2_EXITCODE=0 -DCURL_HAS_H2_EXITCODE__TRYRUN_OUTPUT='' -DCURL_HAS_TLS_PROXY_EXITCODE=0 -DCURL_HAS_TLS_PROXY_EXITCODE__TRYRUN_OUTPUT=''"
