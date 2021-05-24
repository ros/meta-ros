# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "Wrapper around yaml-cpp, it provides a fixed CMake module."

# We arrange for the platform yaml-cpp to be built from the same commit as that from which the ExternalProject is built. If the
# commit changes, the patch will not apply cleanly and we'll know we need to update the .bbappend for yaml-cpp.
DEPENDS += "yaml-cpp"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Use-platform-yaml-cpp.patch"
