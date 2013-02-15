DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake python-empy python-catkin-pkg"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://0001-catkin_package-use-relative-paths-in-PKG_CFG_EXTRAS.patch \
           file://0002-catkinConfig-use-curent-path-for-catkin_EXTRA_DIR.patch \
           "

SRC_URI[md5sum] = "e4df85e60dc792af9324334547cc76aa"
SRC_URI[sha256sum] = "dd99cc04eeaf16a13185dd0a2f576939fa997dfb16a40ba45068c4d2ebbcb44b"

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
