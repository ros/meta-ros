DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake ${PYTHON_PN}-empy-native ${PYTHON_PN}-catkin-pkg-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4c7869362e0c9f62171191ac85c9cfe2"
SRC_URI[sha256sum] = "71a735bee28e4132350fae55c14324ff7cb7c6d0548ee08e5f6d588985001541"

SRC_URI += "\
    file://0001-use-python-provided-by-environment-instead-of-the-ge.patch \
    ${@'file://0001-python.cmake-look-for-python3-first.patch' if d.getVar('PYTHON_PN', True) == 'python3' else ''} \
    "

inherit catkin
