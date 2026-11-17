# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-ogre19.patch"

DEPENDS += " \
    ogre19 \
"

EXTRA_OECMAKE += " -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc"

# package.xml declares "BSD-&-Apache-2.0", which is not a valid license identifier.
# Upstream check: source headers are Apache-2.0 and BSD-3-Clause.
LICENSE = "BSD-3-Clause & Apache-2.0"
