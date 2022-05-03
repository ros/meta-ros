#
# Copyright (c) 2013 Stefan Herbrechtsmeier, Bielefeld University
# Copyright (c) 2019-2021 LG Electronics, Inc.
#

inherit cmake
inherit ros_faulty_solibs
# ROS_PYTHON_VERSION is usually set in generated/superflore-ros-distro.inc, but
# in case superflore-ros-distro.inc isn't included default to 3
ROS_PYTHON_VERSION ?= "3"
inherit ${@'setuptools3-base' if d.getVar('ROS_PYTHON_VERSION') == '3' else 'distutils-base'}

# noetic often provides python scripts which use "/usr/bin/env python" or "/usr/bin/python" shebang
# while we want to install only python3 in the images and no /usr/bin/python symlink (as it cannot
# work well when some components might expect /usr/bin/python to be python2 and some expecting python3)
CATKIN_PYTHON = "python${ROS_PYTHON_VERSION}"

# Used to disable exporting LD_LIBRARY_PATH when building with catkin
# because on builder with the same architecture as target MACHINE it
# will try to use incompatible libraries (e.g. libpython) from TARGET
# sysroot instead using the one from host (e.g. for native python)
export CATKIN_CROSSCOMPILING = "1"

EXTRA_OECMAKE_CATKIN = "\
    -DPYTHON_EXECUTABLE_TARGET='/usr/bin/env python3' \
    -DCMAKE_PREFIX_PATH='${STAGING_DIR_HOST}${ros_prefix};${STAGING_DIR_HOST}${prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DCATKIN_DEVEL_PREFIX='${WORKDIR}/devel' \
    "

EXTRA_OECMAKE_CATKIN:class-native = "\
    -DPYTHON_EXECUTABLE_TARGET='/usr/bin/env python3' \
    -DCMAKE_PREFIX_PATH='${ros_prefix}' \
    -DCMAKE_INSTALL_PREFIX:PATH='${ros_prefix}' \
    -DRT_LIBRARY=${libdir_native} \
    -DCATKIN_DEVEL_PREFIX='${WORKDIR}/devel' \
    "

EXTRA_OECMAKE:prepend = "\
    ${EXTRA_OECMAKE_CATKIN} \
    -DCATKIN_BUILD_BINARY_PACKAGE=ON \
    -DSETUPTOOLS_DEB_LAYOUT=OFF \
    -DCATKIN_ENABLE_TESTING=0 \
    "

# similar to what distutil3.bbclass does here:
# https://git.openembedded.org/openembedded-core/tree/meta/classes/distutils3.bbclass?h=hardknott#n46
# but catkin recipe don't inherit whole distutils3 (only distutils3-base) and also with ros_opt_prefix.bbclass
# the files we want to modify aren't in ${bindir}/${sbindir}, but ${ros_prefix}
do_install:append() {
    for i in ${D}${bindir}/* ${D}${sbindir}/* ${D}${ros_prefix}/bin/* ${D}${ros_prefix}/sbin/*; do
        if [ -f "$i" ]; then
            sed -i -e s:${PYTHON}:${USRBINPATH}/env\ ${CATKIN_PYTHON}:g $i
            sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g $i
        fi
    done
}
