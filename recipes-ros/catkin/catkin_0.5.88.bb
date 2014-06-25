DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake python-empy python-catkin-pkg python-empy-native python-catkin-pkg-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "472ff1f0e04f456af65fa16060fc75c6"
SRC_URI[sha256sum] = "e393e114f491d54982d854ba6e878fd85ed9606d6a5cc122d30fd950daed269f"

SRC_URI += "file://0001-CATKIN_WORKSPACES-Don-t-require-.catkin-file.patch"

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

RDEPENDS_${PN}_class-native = ""
RDEPENDS_${PN} = "cmake make binutils binutils-symlinks gcc gcc-symlinks g++ g++-symlinks \
    python-catkin-pkg python-argparse python-misc python-multiprocessing \
    python-shell python-subprocess python-xml python-pkgutil"

BBCLASSEXTEND += "native"
