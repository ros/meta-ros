# Copyright (c) 2019-2021 LG Electronics, Inc.

inherit ros_insane_dev_so python3targetconfig

DEPENDS += "python3-numpy-native"

EXTRA_OECMAKE += "-DPY_DEST=${PYTHON_SITEPACKAGES_DIR}"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://fix.cflags.in.pkg-config.patch \
    file://0001-CMakeLists.txt-allow-to-set-PY_DEST.patch \
"

# apriltag/3.4.3-2/recipe-sysroot-native/usr/lib/python3.12/site-packages/numpy/core/include/numpy/__multiarray_api.h:646:11: error: ISO C forbids conversion of object pointer to function pointer type [-Werror=pedantic]
OECMAKE_C_FLAGS:append = " -Wno-error=pedantic"
