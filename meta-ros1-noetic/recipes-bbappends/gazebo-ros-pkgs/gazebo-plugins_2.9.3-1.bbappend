# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-ogre19.patch"

DEPENDS += " \
    ogre19 \
"

EXTRA_OECMAKE += " -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc"
