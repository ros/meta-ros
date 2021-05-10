# Copyright (c) 2019-2021 LG Electronics, Inc.

SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "e3e7ccd35a85f9cd38c67cb1988251f1543b6632"
SRC_URI = "git://github.com/awslabs/${BPN}.git;protocol=https;branch=main"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
