# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# Below this line not copyrighted

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Rewriting-findCaller-function-for-python3.12.patch"
