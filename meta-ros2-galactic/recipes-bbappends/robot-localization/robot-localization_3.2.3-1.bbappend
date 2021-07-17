# Copyright (c) 2021 LG Electronics, Inc.

# backports from 3.2.3 to fix compatibility with galactic roscpp and image_pipeline
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "\
    file://0001-Add-missing-message_filters-dependency-666.patch \
    file://0002-Remove-try-catch-blocks-around-declare_parameter-663.patch \
    file://0003-Revert-Enable-QoS-overrides-657.patch \
"

SRC_URI += "file://0004-Fix-build-with-gcc-11-by-switching-from-std-c-14-to-.patch"
