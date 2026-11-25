# Copyright (c) 2025 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-fixyywrap.patch \
            file://use-pkgconfig.patch"

inherit pkgconfig

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    bison-native \
    flex-native \
"

do_compile:append() {
    sed -i -e "s#${WORKDIR}#<WORKDIR>#g" ${B}/lex.yy.cc
    sed -i -e "s#${WORKDIR}#<WORKDIR>#g" ${B}/pddl+.cpp
}
