#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 

inherit cmake distutils-base

DEPENDS_prepend = "${@['catkin-native ', ''][d.getVar('BPN', True) == 'catkin']}"

EXTRA_OECMAKE_CATKIN = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}/usr;${STAGING_DIR_NATIVE}/usr' \
    "

EXTRA_OECMAKE_CATKIN_class-native = "\
    -DCMAKE_PREFIX_PATH=${STAGING_DIR_NATIVE}/usr \
    -DRT_LIBRARY=${libdir_native} \
    "

EXTRA_OECMAKE_prepend = "\
    ${EXTRA_OECMAKE_CATKIN} \
    -DCATKIN_BUILD_BINARY_PACKAGE=ON \
    -DSETUPTOOLS_DEB_LAYOUT=OFF \
    -DCATKIN_ENABLE_TESTING=0 \
    "

OECMAKE_SOURCEPATH = "${S}"
OECMAKE_BUILDPATH = "${S}/build"

export BUILD_SYS
export HOST_SYS

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"

ROS_BPN = "${@d.getVar('BPN', True).replace('-', '_')}"
ROS_BP = "${ROS_BPN}-${PV}"

FILES_${PN} += "\
    ${prefix}/etc \
    ${datadir}/ros/config/${ROS_BPN}.config \
    ${datadir}/${ROS_BPN} \
    "

FILES_${PN}-dev += "\
    ${datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/*.template \
    "

FILES_${PN}-dbg += "\
    ${libdir}/${ROS_BPN}/.debug/* \
    "

PACKAGES += "${PN}-commonlisp"

FILES_${PN}-commonlisp += " \
    ${datadir}/common-lisp/ \
    "

SYSROOT_PREPROCESS_FUNCS += "catkin_sysroot_preprocess"

catkin_sysroot_preprocess () {
    sysroot_stage_dir ${D}${prefix}/etc ${SYSROOT_DESTDIR}${prefix}/etc
}

BBCLASSEXTEND += "native"
