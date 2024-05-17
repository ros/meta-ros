# Copyright (c) Qualcomm Innovation Center, Inc. All rights reserved

# The SOABI setting changed in newer python3 with:
# http://git.openembedded.org/openembedded-core/commit/?h=warrior&id=f3326309c7c22a6034917f6eee21908c61f44a2f
# https://github.com/python/cpython/pull/13196/commits/752b61141da76e81e53700bdbea81cd95af617b6


PYTHON_SOABI_ARCH = "${TUNE_ARCH}-${TARGET_OS}"
PYTHON_SOABI_ARCH_SUFFIX = "-gnu"
# The suffix is already included in TARGET_OS
PYTHON_SOABI_ARCH_SUFFIX:arm = ""
# Another exception is i686 TUNE_ARCH in dunfell and newer with this change:
# https://git.openembedded.org/openembedded-core/commit/?h=dunfell&id=6beab388e73b3ac6157650855a6c1fb1d71e8015
PYTHON_SOABI_ARCH:i686 = "i386-${TARGET_OS}"
PYTHON_SOABI = "cpython-${@d.getVar('PYTHON_BASEVERSION').replace('.', '')}${PYTHON_ABI}-${PYTHON_SOABI_ARCH}${PYTHON_SOABI_ARCH_SUFFIX}"

EXTRA_OECMAKE:append = " -DBUILD_TESTING=OFF"
EXTRA_OECMAKE:append:class-target = " -DPYTHON_SOABI=${PYTHON_SOABI}"

# XXX Without STAGING_DIR_HOST path included, rmw-implementation:do_configure() fails with:
#
#    "Could not find ROS middleware implementation 'NOTFOUND'"
#
export AMENT_PREFIX_PATH="${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${prefix};${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_NATIVE}${ros_prefix}"

inherit cmake python3native

FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

EXTRA_OECMAKE:prepend = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
"

EXTRA_OECMAKE:prepend:class-native = "\
    -DCMAKE_PREFIX_PATH='${ros_prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
"
