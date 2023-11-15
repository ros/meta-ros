# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

inherit pkgconfig

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-use-pkg-config-to-find-yaml.patch \
    file://0001-fix-libdir.patch \
"

EXTRA_OECMAKE += " -DPYTHON_INSTALL_DIR=${baselib}/${PYTHON_DIR}/site-packages"
