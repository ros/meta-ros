# Copyright (c) 2018-2019 LG Electronics, Inc.

S = "${WORKDIR}/git/${ROS_BPN}"

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

FILES_${PN} = " \
    /usr/share/* \
    ${datadir}/${ROS_BPN}/package.xml \
    ${datadir}/${ROS_BPN}/resource/* \
    ${datadir}/ament_index/* \
    ${libdir}/${PYTHON_DIR}/* \
    ${libdir}/${ROS_BPN}/* \
    ${libdir}/lib*.so \
"

