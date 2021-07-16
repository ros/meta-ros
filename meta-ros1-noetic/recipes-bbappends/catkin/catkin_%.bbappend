# Copyright (c) 2019-2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-Use-PYTHON_EXECUTABLE_TARGET-instead-of-PYTHON_EXECU.patch \
    file://0002-allow-proper-cross-compilation-with-catkin.patch \
    file://0003-builder.py-don-t-prepend-ld_path-to-LD_LIBRARY_PATH.patch \
"

ROS_BUILD_DEPENDS:remove = "${PYTHON_PN}-catkin-pkg"
ROS_BUILD_DEPENDS:remove = "${PYTHON_PN}-empy"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-catkin-pkg-native \
    ${PYTHON_PN}-empy-native \
"

EXTRA_OECMAKE:prepend = " \
    -DCATKIN_INSTALL_INTO_PREFIX_ROOT=ON \
"

CATKIN_PREFIX_ROOT_FILES = " \
    ${ros_prefix}/.catkin \
    ${ros_prefix}/.rosinstall \
    ${ros_prefix}/_setup_util.py \
    ${ros_prefix}/*.bash \
    ${ros_prefix}/*.zsh \
    ${ros_prefix}/*.sh \
"

FILES:${PN}:prepend = "${CATKIN_PREFIX_ROOT_FILES} "

SSTATE_SCAN_FILES:append = " _setup_util.py"
# Must do this to include CATKIN_PREFIX_ROOT_FILES. It might add "extra" files to what's staged, but who cares?
SYSROOT_DIRS:append = " ${ros_prefix}"

# XXX Why doesn't SSTATE_SCAN_FILES fix this up?
do_install:append:class-target() {
    sed -i -e 's@${RECIPE_SYSROOT}/@/@g' ${D}${ros_prefix}/_setup_util.py

    mkdir -p ${D}${sysconfdir}/profile.d
    echo ". ${ros_prefix}/setup.sh" > ${D}${sysconfdir}/profile.d/ros.sh
}

do_install:append() {
    # because distutils is called with this PYTHON ${STAGING_BINDIR_NATIVE}/python3-native/python3
    # it also updates the shebang while installing catkin scripts, we need to undo that
    sed -i 's@#!${STAGING_BINDIR_NATIVE}/python3-native/python3@#!/usr/bin/env python3@g' ${D}${ros_bindir}/catkin_*
}

# NB. COMPLEMENTARY_GLOB[ros-implicit-workspace] = "*-implicitworkspace"
PACKAGES =+ "${PN}-implicitworkspace"

FILES:${PN}-implicitworkspace = " \
    ${sysconfdir}/profile.d/ros.sh \
"

# Used to disable exporting LD_LIBRARY_PATH when building with catkin
# because on builder with the same architecture as target MACHINE it
# will try to use incompatible libraries (e.g. libpython) from TARGET
# sysroot instead using the one from host (e.g. for native python)
export CATKIN_CROSSCOMPILING = "1"

EXTRA_OECMAKE = " -DPYTHON_EXECUTABLE_TARGET='/usr/bin/env python3'"

# inherit python3native
