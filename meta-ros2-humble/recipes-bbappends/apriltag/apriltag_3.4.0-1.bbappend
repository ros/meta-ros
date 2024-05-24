# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

inherit ros_insane_dev_so python3targetconfig

# Copied from ros_ament_cmake
# The SOABI setting changed in newer python3 with:
PYTHON_SOABI_ARCH = "${TUNE_ARCH}-${TARGET_OS}"
PYTHON_SOABI_ARCH_SUFFIX = "-gnu"
PYTHON_SOABI_ARCH_SUFFIX:arm = ""
PYTHON_SOABI_ARCH:i686 = "i386-${TARGET_OS}"
PYTHON_SOABI = "cpython-${@d.getVar('PYTHON_BASEVERSION').replace('.', '')}${PYTHON_ABI}-${PYTHON_SOABI_ARCH}${PYTHON_SOABI_ARCH_SUFFIX}"
EXTRA_OECMAKE:append:class-target = " -DPYTHON_SOABI=${PYTHON_SOABI}"

DEPENDS += "python3-numpy-native"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://Set-Python-SOABI.patch"
