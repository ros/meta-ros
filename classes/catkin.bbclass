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
    "

OECMAKE_SOURCEPATH = "${S}"
OECMAKE_BUILDPATH = "${S}/build"

export BUILD_SYS
export HOST_SYS

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/lib*${SOLIBSDEV}"

ROS_BPN = "${@d.getVar('BPN', True).replace('-', '_')}"
ROS_BP = "${BPN}-${PV}"

FILES_${PN} += "\
    ${prefix}/etc \
    ${datadir}/ros/config/${ROS_BPN}.config \
    ${datadir}/${ROS_BPN} \
    "

FILES_${PN}-dev += "\
    ${datadir}/${ROS_BPN}/cmake \
    ${datadir}/${ROS_BPN}/package.xml \
    ${datadir}/${ROS_BPN}/*.template \
    "

FILES_${PN}-dbg += "\
    ${libdir}/${ROS_BPN}/.debug/* \
    "

BBCLASSEXTEND += "native"
