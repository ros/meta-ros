# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-sensors.git;protocol=https;branch=gz-sensors8"

SRCREV = "f44c31f6ddedff4440d2df8896f77ab94dcc25d2"


DEPENDS += " \
    cppcheck-native \
    doxygen-native \
    gz-cmake3 \
    gz-common5 \
    gz-math7 \
    gz-msgs10 \
    gz-rendering8 \
    gz-transport13 \
    protobuf \
    protobuf-native \
    sdformat \
"

inherit cmake

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

do_install:append() {
    # Remove references to the build directory in the Doxygen tagfile
    sed -i -e "s:${S}::g" ${D}${datadir}/gz/gz-sensors8/gz-sensors8.tag.xml
}

FILES:${PN} += "${datadir}/gz/gz-sensors8"
