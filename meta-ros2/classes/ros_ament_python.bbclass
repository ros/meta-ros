# Copyright (c) 2018-2019 LG Electronics, Inc.

inherit setuptools3_legacy

do_install:append() {
    mkdir -p ${D}${datadir}/ament_index/resource_index/packages
    touch ${D}${datadir}/ament_index/resource_index/packages/${ROS_BPN}
    if test -e ${D}${libdir}/${ROS_BPN}; then
        for i in ${D}${libdir}/${ROS_BPN}/* ${D}${libdir}/${ROS_BPN}/*/*; do
            [ -f $i ] && sed -i '1c#!/usr/bin/python3' $i
        done
        true
    fi
}

FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"
