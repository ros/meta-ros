# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport.git;protocol=https;branch=gz-transport15"

SRCREV = "05cd874ac9a1b33a7777a74bc8a2960f3429f267"

inherit cmake pkgconfig python3targetconfig

DEPENDS = " \
    gz-cmake \
    gz-msgs \
    gz-utils \
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

FILES:${PN} += " \
  ${libdir}/ruby/gz \
  ${libdir}/python/gz \
  ${datadir}/gz \
"

BBCLASSEXTEND = "native nativesdk"
