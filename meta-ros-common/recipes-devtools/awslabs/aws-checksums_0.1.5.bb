# Copyright (c) 2019 LG Electronics, Inc.

SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRCREV = "519d6d9093819b6cf89ffff589a27ef8f83d0f65"
SRC_URI = "git://github.com/awslabs/${BPN}.git;protocol=https"
S = "${WORKDIR}/git"

inherit cmake ros_faulty_solibs

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
