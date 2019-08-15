#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# Copyright (c) 2019 LG Electronics, Inc.
#

# ROS_PYTHON_VERSION is set in generated-ros-distro.inc, ie, it will never be unset here.
inherit cmake ${@'distutils3-base' if d.getVar('ROS_PYTHON_VERSION', True) == '3' else 'distutils-base'} faulty-solibs

EXTRA_OECMAKE_CATKIN = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DCATKIN_DEVEL_PREFIX='${WORKDIR}/devel' \
    "

EXTRA_OECMAKE_CATKIN_class-native = "\
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_NATIVE}${ros_prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DRT_LIBRARY=${libdir_native} \
    -DCATKIN_DEVEL_PREFIX='${WORKDIR}/devel' \
    "

EXTRA_OECMAKE_prepend = "\
    ${EXTRA_OECMAKE_CATKIN} \
    -DCATKIN_BUILD_BINARY_PACKAGE=ON \
    -DSETUPTOOLS_DEB_LAYOUT=OFF \
    -DCATKIN_ENABLE_TESTING=0 \
    "
