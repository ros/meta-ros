# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-ogre-next.patch"

DEPENDS += "ogre-next"

# libxaw is empty, the library is installed in libxaw6 and libxaw7 packages
# and ogre should get runtime dependency automatically through shlibs
RDEPENDS:${PN}:remove = "libxaw"
