# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-use-python-provided-by-environment-instead-of-the-ge.patch \
    file://0001-allow-proper-cross-compilation-with-catkin.patch \
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
