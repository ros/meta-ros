#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# 

ROS_USE_PYTHON3 ??= "no"

inherit cmake ${@'distutils3-base' if bb.utils.to_boolean(d.getVar('ROS_USE_PYTHON3', True)) else 'distutils-base'} ros faulty-solibs

DEPENDS_prepend = "${@'' if (d.getVar('BPN', True) == 'catkin') or (d.getVar('BPN', True) == 'catkin-runtime') else 'catkin-native '}"

EXTRA_OECMAKE_CATKIN = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix};${STAGING_DIR_NATIVE}${ros_prefix};${STAGING_DIR_NATIVE}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    "

EXTRA_OECMAKE_CATKIN_class-native = "\
    -DCMAKE_PREFIX_PATH='${ros_prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
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

# Having a command like `find_package(catkin COMPONENTS roscpp)` in a package's CMakeLists.txt
# leads to adding "-Wl,-rpath=${RECIPE_SYSROOT}${ros_libdir}" option to the cross-linker.
# However starting from binutils 2.29 the cross-linker prepends this path with the value
# of --sysroot option thus producing wrong effective path (see https://sourceware.org/ml/binutils/2017-03/msg00161.html)
# These options help to aleviate the problem.
OECMAKE_C_LINK_FLAGS += "-Wl,-rpath-link=${RECIPE_SYSROOT}${ros_libdir}"
OECMAKE_CXX_LINK_FLAGS += "-Wl,-rpath-link=${RECIPE_SYSROOT}${ros_libdir}"

export BUILD_SYS
export HOST_SYS

SYSROOT_PREPROCESS_FUNCS += "catkin_sysroot_preprocess"
catkin_sysroot_preprocess () {
    sysroot_stage_dir ${D}${ros_sysconfdir} ${SYSROOT_DESTDIR}${ros_sysconfdir}
}
