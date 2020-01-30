# Copyright (c) 2020 LG Electronics, Inc.

# Depends on gstreamer1.0-* with this restriction:
inherit distro_features_check
REQUIRED_DISTRO_FEATURES_append_rpi = " opengl"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Make-it-compatible-with-OpenCV-3.4.patch"
