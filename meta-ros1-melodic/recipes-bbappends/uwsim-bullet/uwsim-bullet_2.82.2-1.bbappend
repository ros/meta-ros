# Copyright (c) 2019-2020 LG Electronics, Inc.

# The value from package.xml "Check-author's-website" breaks parsing it with bitbake
# Now superflore replaces it with "Check-authors-website", but we have already
# checked author's website and it shows Zlib license, so just use that
_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('Check-authors-website', 'Zlib')}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-Don-t-include-usr-include-and-usr-loc.patch"
