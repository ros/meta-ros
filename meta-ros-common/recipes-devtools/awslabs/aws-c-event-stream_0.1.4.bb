# Copyright (c) 2019 LG Electronics, Inc.

SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "32713d30b479690d199b3f02163a832b09b309a5"
SRC_URI = "git://github.com/awslabs/${BPN}.git;protocol=https;branch=main"
S = "${WORKDIR}/git"

inherit cmake

DEPENDS += "aws-c-common aws-checksums"

EXTRA_OECMAKE += "-DCMAKE_MODULE_PATH=${STAGING_DIR_HOST}${libdir}/cmake"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
