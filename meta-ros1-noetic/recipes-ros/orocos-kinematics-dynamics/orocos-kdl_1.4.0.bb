# Copyright (c) 2020-2021 LG Electronics, Inc.

require orocos-kdl.inc

DESCRIPTION = "Kinematics and Dynamics Library (KDL), distributed by the Orocos Project."
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8ffd58e6eb29a955738b8fcc9e9e8f2"

S = "${WORKDIR}/git/orocos_kdl"

DEPENDS = "libeigen"

FILES:${PN}-dev += "${datadir}/orocos_kdl"

SRC_URI += "file://0001-KDLConfig.cmake.in-don-t-include-absolute-patch-to-E.patch;patchdir=.."
