# Copyright (c) 2020 LG Electronics, Inc.

# We arrange for the platform ogre to be built from the same commit as that from which the ExternalProject is built. If the
# commit changes, the patch will not apply cleanly and we'll know we need to update the .bbappend for yaml-cpp.
DEPENDS += "ogre"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-remove-all-ExternalProject_Add-calls-and-.patch"

# libxaw is empty, the library is installed in libxaw6 and libxaw7 packages
# and ogre should get runtime dependency automatically through shlibs
RDEPENDS_${PN}_remove = "libxaw"
