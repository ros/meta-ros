# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=388d6baacb3a7c79a82bd82a679c65f3 \
                    file://cli/LICENSE;md5=b73927b18d5c6cd8d2ed28a6ad539733"

SRC_URI = "git://github.com/gazebosim/gz-utils.git;protocol=https;branch=gz-utils3"

SRCREV = "5e1e78be9e4df46c4cfc97165a6447753d179cff"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "gz-cmake4"

BBCLASSEXTEND = "native nativesdk"
