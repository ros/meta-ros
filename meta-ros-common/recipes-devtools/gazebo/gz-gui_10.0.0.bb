# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-gui.git;protocol=https;branch=gz-gui10"

SRCREV = "982993998efd8b5337578d8cd927d32818364532"

inherit cmake

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

DEPENDS = " \
    cppcheck-native \
    doxygen-native \
    gz-cmake \
    gz-common \
    gz-math \
    gz-msgs \
    gz-plugin \
    gz-rendering \
    gz-tools \
    gz-transport \
    gz-utils \
    protobuf \
    protobuf-native \
    libtinyxml2 \
    qtbase \
    qtdeclarative \
    qtdeclarative-native \
"
DEPENDS:append:class-target = "xserver-xorg"

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += " \
    ${libdir}/gz-gui-10/plugins/* \
    ${libdir}/ruby/gz/* \
    ${datadir}/gz/* \
"

BBCLASSEXTEND = "native nativesdk"
