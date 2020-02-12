# Copyright (c) 2018-2019 LG Electronics, Inc.

inherit setuptools3

do_install_append() {
    mkdir -p ${D}/usr/share/ament_index/resource_index/packages
    touch ${D}/usr/share/ament_index/resource_index/packages/${ROS_BPN}
    if test -e ${D}/usr/lib/${ROS_BPN}; then
        for i in ${D}/usr/lib/${ROS_BPN}/* ; do \
            sed -i '1c#!/usr/bin/python3' $i
        done
    fi
}

FILES_${PN}_prepend = " \
    ${datadir}/ament_index \
"
