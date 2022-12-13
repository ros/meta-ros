# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# ament_cmake_python has changed from distutils.sysconfig.get_python_lib() to sysconfig.get_path
# This requires a backport of the changes made in oe-core 72a75043a946f7db01d3ec04c8889e055f542cca
SRC_URI:append = "file://0001-Revert-Lib-sysconfig.py-use-libdir-values-from-configuratio.patch \
            file://0001-Lib-sysconfig.py-use-prefix-value-from-build-configu.patch \
            file://0003-sysconfig.py-use-platlibdir-also-for-purelib.patch \
"
