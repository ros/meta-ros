# Copyright (c) 2019 LG Electronics, Inc

FILESEXTRAPATHS_prepend := "${THISDIR}/camera-calibration-parsers:"
SRC_URI += " \
     file://drop-boost-python-find.patch \
"
