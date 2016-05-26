#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 

ROS_BPN = "${@d.getVar('BPN', True).replace('-', '_')}"

ROS_SPN ?= "${ROS_BPN}"
ROS_SP = "${ROS_SPN}-${PV}"

export ros_prefix = "${base_prefix}/opt/ros/${ROSDISTRO}"

export ros_bindir = "${ros_prefix}/bin"
export ros_libdir = "${ros_prefix}/${baselib}"
export ros_libexecdir = "${ros_libdir}/${ROS_BPN}"
export ros_includedir = "${ros_prefix}/include"
export ros_datadir = "${ros_prefix}/share"
export ros_sysconfdir = "${ros_prefix}/etc"
export ros_stacksdir = "${ros_prefix}/stacks"

PREPROCESS_RELOCATE_DIRS += " \
    ${ros_bindir} \
    ${ros_libdir} \
"

PKG_CONFIG_PATH .= ":${PKG_CONFIG_DIR}:${STAGING_DIR_HOST}${ros_libdir}/pkgconfig:${STAGING_DATADIR}/pkgconfig"
PYTHON_SITEPACKAGES_DIR = "${ros_libdir}/${PYTHON_DIR}/site-packages"
export PYTHONPATH = "${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}"
PYTHONPATH_class-native = "${PYTHON_SITEPACKAGES_DIR}"

FILES_${PN} += "\
    ${ros_bindir}/* ${ros_libexecdir}/* ${ros_libdir}/lib*.so \
    ${PYTHON_SITEPACKAGES_DIR} \
    ${ros_datadir} \
    ${ros_sysconfdir} \
    ${ros_stacksdir} \
    "

FILES_${PN}-dev += "\
    ${ros_includedir} \
    ${ros_libdir}/pkgconfig \
    ${PYTHON_SITEPACKAGES_DIR}/*.la \
    ${ros_datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/*.template \
    "

FILES_${PN}-dbg += "\
    ${ros_bindir}/.debug ${ros_libexecdir}/.debug ${ros_libdir}/.debug \
    ${ros_datadir}/*/bin/.debug \
    ${PYTHON_SITEPACKAGES_DIR}/.debug \
    ${PYTHON_SITEPACKAGES_DIR}/*/.debug \
    ${PYTHON_SITEPACKAGES_DIR}/*/*/.debug \
    "

FILES_${PN}-staticdev += "\
    ${ros_libdir}/*.a \
    ${ros_libdir}/${BPN}/*.a \
    "

PACKAGES += "${PN}-commonlisp"

FILES_${PN}-commonlisp += " \
    ${datadir}/common-lisp/ \
    "

SYSROOT_PREPROCESS_FUNCS += "ros_sysroot_preprocess"
ros_sysroot_preprocess () {
    sysroot_stage_dir ${D}${ros_includedir} ${SYSROOT_DESTDIR}${ros_includedir}
    if [ "${BUILD_SYS}" = "${HOST_SYS}" ]; then
        sysroot_stage_dir ${D}${ros_bindir} ${SYSROOT_DESTDIR}${ros_bindir}
        sysroot_stage_dir ${D}${ros_sysconfdir} ${SYSROOT_DESTDIR}${ros_sysconfdir}
    fi
    if [ -d ${D}${ros_libdir} ]; then
        sysroot_stage_dir ${D}${ros_libdir} ${SYSROOT_DESTDIR}${ros_libdir}
    fi
    sysroot_stage_dir ${D}${ros_datadir} ${SYSROOT_DESTDIR}${ros_datadir}
    if [ -d ${D}${ros_stacksdir} ]; then
        sysroot_stage_dir ${D}${ros_stacksdir} ${SYSROOT_DESTDIR}${ros_stacksdir}
    fi
}
