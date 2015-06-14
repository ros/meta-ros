DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake python-empy python-catkin-pkg python-empy-native python-catkin-pkg-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e6d1090589026746c94d8fae78015167"
SRC_URI[sha256sum] = "0ca265803be8a2c1b6036d67ed63505551f4bbc02fa6cb8180dc3167b9f3afc9"

SRC_URI += "file://0001-CATKIN_WORKSPACES-Don-t-require-.catkin-file.patch\
            file://0002-PKG_CONFIG_LIB_PATHS-use-cmake-root-path.patch"

inherit catkin

FILES_${PN}-dev += "\
    ${ros_datadir}/eigen/cmake \
    ${ros_datadir}/ros/cmake \
    ${ros_datadir}/.catkin \
    ${ros_prefix}/.catkin \
    ${ros_prefix}/.rosinstall \
    ${ros_prefix}/_setup_util.py \
    ${ros_prefix}/env.sh \
    ${ros_prefix}/setup.* \
    "

