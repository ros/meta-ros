#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
#

ROS_USE_PYTHON3 ??= "no"

inherit cmake ${@'distutils3-base' if bb.utils.to_boolean(d.getVar('ROS_USE_PYTHON3', True)) else 'distutils-base'} ros faulty-solibs
# Prepend build dependency on "catkin-runtime" and "catkin-native"
# if the package is not "catkin" or "catkin-runtime"
DEPENDS_prepend = "${@['catkin-runtime catkin-native ', ''][(d.getVar('BPN', True) == 'catkin') | (d.getVar('BPN', True) == 'catkin-runtime')]}"

# Prepend run dependency on "catkin" for *-dev packages
# if the package is not "catkin" or "catkin-runtime"
RDEPENDS_${PN}_prepend_class-dev = "${@['catkin ', ''][(d.getVar('BPN', True) == 'catkin') | (d.getVar('BPN', True) == 'catkin-runtime')]}"

EXTRA_OECMAKE_CATKIN = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${ros_prefix};${STAGING_DIR_NATIVE}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DCATKIN_DEVEL_PREFIX='${WORKDIR}/devel' \
    "

EXTRA_OECMAKE_CATKIN_class-native = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_NATIVE}${ros_prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DCATKIN_DEVEL_PREFIX='${WORKDIR}/devel' \
    -DRT_LIBRARY=${libdir_native} \
    "

EXTRA_OECMAKE_prepend = "\
    ${EXTRA_OECMAKE_CATKIN} \
    -DCATKIN_BUILD_BINARY_PACKAGE=ON \
    -DSETUPTOOLS_DEB_LAYOUT=OFF \
    -DCATKIN_ENABLE_TESTING=0 \
    "

export BUILD_SYS
export HOST_SYS

do_configure_prepend() {
    rm -rf ${WORKDIR}/devel
    mkdir -p ${WORKDIR}/devel
}

SYSROOT_PREPROCESS_FUNCS += "catkin_sysroot_preprocess"
catkin_sysroot_preprocess () {
    sysroot_stage_dir ${D}${ros_sysconfdir} ${SYSROOT_DESTDIR}${ros_sysconfdir}
}
