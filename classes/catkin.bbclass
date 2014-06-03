#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 

inherit cmake distutils-base ros faulty-solibs

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

SYSROOT_PREPROCESS_FUNCS += "catkin_sysroot_preprocess"

catkin_sysroot_preprocess () {
    sysroot_stage_dir ${D}${prefix}/etc ${SYSROOT_DESTDIR}${prefix}/etc
}
