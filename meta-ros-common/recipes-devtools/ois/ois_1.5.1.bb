# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "Zlib"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=db5da1a57f92d70695878148529ef329"

SRC_URI = "git://github.com/wgois/OIS;protocol=https;branch=master"

SRCREV = "6edb487cccb54d59e5b0fff86549d5eef475dea6"

S = "${WORKDIR}/git"

DEPENDS = "libx11 xinput"

inherit cmake
