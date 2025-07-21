# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport.git;protocol=https;branch=gz-transport14 \
           file://fix-compatibility-with-protobuf-v30.patch"

SRCREV = "c79276843edf4264e9b78d57b557f46e2e527b14"


inherit cmake pkgconfig python3targetconfig

DEPENDS = " \
    gz-cmake4 \
    gz-msgs11 \
    gz-utils3 \
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
