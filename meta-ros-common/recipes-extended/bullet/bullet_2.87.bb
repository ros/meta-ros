# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "Real-time collision detection and multi-physics simulation"
HOMEPAGE = "https://github.com/bulletphysics/bullet3"
SECTION = "devel"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=74f06ab3011994d1b43d71ecbb42a7cf"

SRCREV = "6e4707df5fa1f9927109e89a7cd2a6d6a6ddd072"
SRC_URI = "git://github.com/bulletphysics/bullet3;protocol=https \
    file://0001-CMakeLists.txt-Use-FindPython2-instead-of-deprecated.patch \
"
S = "${WORKDIR}/git"

inherit cmake
inherit distutils-base

DEPENDS = "python-numpy"

# From https://github.com/bulletphysics/bullet3/blob/master/build_cmake_pybullet_double.sh
EXTRA_OECMAKE = "-DBUILD_PYBULLET=ON -DBUILD_PYBULLET_NUMPY=ON -DUSE_DOUBLE_PRECISION=ON -DBT_USE_EGL=ON -DCMAKE_BUILD_TYPE=Release"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON -DINSTALL_LIBS=ON -DINSTALL_EXTRA_LIBS=ON"

CFLAGS += "-fsigned-char"
CXXFLAGS += "-fsigned-char"
