# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=388d6baacb3a7c79a82bd82a679c65f3 \
                    file://cli/LICENSE;md5=b73927b18d5c6cd8d2ed28a6ad539733"

SRC_URI = "git://github.com/gazebosim/gz-utils.git;protocol=https;branch=gz-utils3"

SRCREV = "fd0a40c09be4fd7b2a40d877bb56d2fa1c7607e3"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "gz-cmake4 spdlog"

BBCLASSEXTEND = "native nativesdk"
