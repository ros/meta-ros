DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake ${PYTHON_PN}-empy-native ${PYTHON_PN}-catkin-pkg-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d58460cc9112812d8c4e6ecf98bbcc85"
SRC_URI[sha256sum] = "90a639d67db7f9039487af555e432a5b4b6e339f22892d75d03b823b3f38c947"

SRC_URI += "\
    file://0001-use-python-provided-by-environment-instead-of-the-ge.patch \
    file://0001-allow-proper-cross-compilation-with-catkin.patch \
    ${@'file://0001-python.cmake-look-for-python3-first.patch' if d.getVar('PYTHON_PN', True) == 'python3' else ''} \
    "

inherit catkin
