# Copyright (c) 2019 LG Electronics, Inc.

# Missing license version in package.xml maps it to invalid LGPL-2
# https://github.com/orocos/orocos-kdl-release/issues/4
LICENSE = "LGPL-2.1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://fix-findsip-cmake.patch \
"

# "sip" is a build tool.
DEPENDS_append = " sip-native"
DEPENDS_remove = "sip"

RDEPENDS_${PN}_remove = "sip"
