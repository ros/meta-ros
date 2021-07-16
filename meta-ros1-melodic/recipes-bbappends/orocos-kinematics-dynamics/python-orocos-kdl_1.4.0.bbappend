# Copyright (c) 2019-2020 LG Electronics, Inc.

# Missing license version in package.xml
# https://github.com/orocos/orocos-kdl-release/issues/4
LICENSE = "LGPL-2.1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://fix-findsip-cmake.patch \
"

# "sip" is a build tool.
DEPENDS:append = " sip-native"
DEPENDS:remove = "sip"

RDEPENDS:${PN}:remove = "sip"
