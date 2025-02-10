# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport.git;protocol=https;branch=gz-transport13"

SRCREV = "73757e716dcf21e395e1884fbfb4afc6bac10d85"

S = "${WORKDIR}/git"

inherit cmake pkgconfig python3targetconfig

DEPENDS = " \
    gz-cmake3 \
    gz-msgs10 \
    gz-utils2 \
    sqlite3 \
    util-linux-libuuid \
    zeromq \
    cppzmq \
    doxygen-native \
    graphviz-native \
    protobuf \
    protobuf-native \
    cppcheck-native \
    python3-pytest-native \
"

RDEPENDS:${PN} += "ruby"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

do_install:append() {
    # Remove references to the build directory in the Doxygen tagfile
    sed -i -e "s:${S}::g" ${D}${datadir}/gz/gz-transport13/gz-transport13.tag.xml
}

FILES:${PN} += " \
  ${libdir}/ruby/gz \
  ${libdir}/python/gz \
  ${datadir}/gz \
"

BBCLASSEXTEND = "native nativesdk"
