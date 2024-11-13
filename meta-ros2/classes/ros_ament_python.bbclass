# Copyright (c) 2018-2019 LG Electronics, Inc.
# Copyright (c) Qualcomm Innovation Center, Inc. All rights reserved

inherit setuptools3_legacy

do_install:append() {
    mkdir -p ${D}${ros_datadir}/ament_index/resource_index/packages
    touch ${D}${ros_datadir}/ament_index/resource_index/packages/${ROS_BPN}
    if test -e ${D}${ros_libdir}/${ROS_BPN}; then
        for i in ${D}${ros_libdir}/${ROS_BPN}/* ${D}${ros_libdir}/${ROS_BPN}/*/*; do
            [ -f $i ] && sed -i '1c#!/usr/bin/python3' $i
        done
        true
    fi

    # similar to what setuptools3_legacy.bbclass does here:
    for i in ${D}${ros_bindir}/* ${D}${ros_sbindir}/*; do
        if [ -f "$i" ]; then
            sed -i -e s:${PYTHON}:${USRBINPATH}/env\ ${SETUPTOOLS_PYTHON}:g $i
            sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i
        fi
    done
}

FILES:${PN}:prepend = " \
    ${ros_datadir}/ament_index \
"

PYTHON_SITEPACKAGES_DIR = "${ros_libdir}/${PYTHON_DIR}/site-packages"

SETUPTOOLS_INSTALL_ARGS = "--root=${D} \
    --prefix=${ros_prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${ros_datadir}"
