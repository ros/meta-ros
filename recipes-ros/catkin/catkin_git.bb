DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake python-empy python-catkin-pkg"

SRC_URI = "git://github.com/ros/${BPN}.git \
           file://0001-pkgConfig.cmake-use-filenames-in-PKG_CFG_EXTRAS.patch \
           file://0002-catkin_package.cmake-use-PROJECT_NAME-_EXTRAS_DIR-fo.patch \
           "

SRCREV = "cbe6a0ce3ac6d13914d3b4b010148f72e7984149"
PV = "0.5.63+gitr${SRCPV}"

S = "${WORKDIR}/git"

inherit catkin

FILES_${PN}-dev += "\
    ${datadir}/eigen/cmake \
    ${datadir}/ros/cmake \
    ${prefix}/.catkin \
    ${prefix}/.rosinstall \
    ${prefix}/_setup_util.py \
    ${prefix}/env.sh \
    ${prefix}/setup.* \
    "

BBCLASSEXTEND += "native"
