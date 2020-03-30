# Copyright (c) 2019-2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-use-python-provided-by-environment-instead-of-the-ge.patch \
    file://0002-allow-proper-cross-compilation-with-catkin.patch \
    file://0003-builder.py-don-t-prepend-ld_path-to-LD_LIBRARY_PATH.patch \
"

ROS_BUILD_DEPENDS_remove = "python-catkin-pkg"
ROS_BUILD_DEPENDS_remove = "python-empy"

ROS_BUILDTOOL_DEPENDS += " \
    python-catkin-pkg-native \
    python-empy-native \
"

EXTRA_OECMAKE_prepend = " \
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

FILES_${PN}_prepend = "${CATKIN_PREFIX_ROOT_FILES} "

SSTATE_SCAN_FILES_append = " _setup_util.py"
# Must do this to include CATKIN_PREFIX_ROOT_FILES. It might add "extra" files to what's staged, but who cares?
SYSROOT_DIRS_append = " ${ros_prefix}"

# XXX Why doesn't SSTATE_SCAN_FILES fix this up?
do_install_append_class-target() {
    sed -i -e 's@${RECIPE_SYSROOT}/@/@g' ${D}${ros_prefix}/_setup_util.py

    mkdir -p ${D}${sysconfdir}/profile.d
    echo ". ${ros_prefix}/setup.sh" > ${D}${sysconfdir}/profile.d/ros.sh
}

# NB. COMPLEMENTARY_GLOB[ros-implicit-workspace] = "*-implicitworkspace"
PACKAGES =+ "${PN}-implicitworkspace"

FILES_${PN}-implicitworkspace = " \
    ${sysconfdir}/profile.d/ros.sh \
"

# Used to disable exporting LD_LIBRARY_PATH when building with catkin
# because on builder with the same architecture as target MACHINE it
# will try to use incompatible libraries (e.g. libpython) from TARGET
# sysroot instead using the one from host (e.g. for native python)
export CATKIN_CROSSCOMPILING = "1"
