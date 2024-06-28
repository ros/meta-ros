# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) Qualcomm Innovation Center, Inc. All rights reserved

inherit cmake

EXTRA_OECMAKE:prepend = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DCMAKE_MODULE_PATH='${STAGING_DIR_HOST}${ros_datadir}/cmake/Modules/' \
"

EXTRA_OECMAKE:prepend:class-native = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_NATIVE}${ros_prefix};${STAGING_DIR_NATIVE}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
"
