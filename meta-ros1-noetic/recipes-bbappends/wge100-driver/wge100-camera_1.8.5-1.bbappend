# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-build-without-catkin-testing-enab.patch"

# package.xml declares "GPL-because-of-list.h-&-other-files-released-under-BSD", which is not a valid license identifier.
# Upstream check: source headers: list.h is GPL v2 or later, other files BSD-3-Clause.
LICENSE = "GPL-2.0-or-later & BSD-3-Clause"
