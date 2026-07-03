# Copyright (c) 2020 LG Electronics, Inc.

DESCRIPTION = "Real-time collision detection and multi-physics simulation"
HOMEPAGE = "https://github.com/bulletphysics/bullet3"
SECTION = "devel"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=74f06ab3011994d1b43d71ecbb42a7cf"

SRCREV = "7dee3436e747958e7088dfdcea0e4ae031ce619e"
SRC_URI = "git://github.com/bulletphysics/bullet3;protocol=https;branch=master \
           file://add-exported-cmake-targets.patch \
           file://use-find-python3.patch"

inherit cmake python3targetconfig

DEPENDS = "python3-numpy-native"
DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl libglu', '', d)}"

EXTRA_OECMAKE = "\
  -DCMAKE_POLICY_VERSION_MINIMUM=3.5 \
  -DBUILD_SHARED_LIBS=ON \
  -DBUILD_EXTRAS=on\
  -DBULLET2_MULTITHREADING=on\
  -DBUILD_OPENGL3_DEMOS=OFF \
  -DBUILD_CPU_DEMOS=OFF \
  -DBUILD_BULLET_ROBOTICS_GUI_EXTRA=OFF \
  -DBUILD_BULLET_ROBOTICS_EXTRA=OFF \
  -DBUILD_OBJ2SDF_EXTRA=OFF \
  -DINSTALL_LIBS=ON \
  -DINSTALL_EXTRA_LIBS=ON \
  -DUSE_DOUBLE_PRECISION=ON \
  -DCMAKE_BUILD_TYPE=Release \
"

# From build_cmake_pybullet_double.sh
EXTRA_OECMAKE += "-DBUILD_PYBULLET=ON -DBUILD_PYBULLET_NUMPY=ON"
EXTRA_OECMAKE += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '-DBT_USE_EGL=ON', '', d)}"

# Tries to link with prebuilt x86 libraries e.g.
# aarch64-oe-linux/9.3.0/ld: skipping incompatible
# aarch64-oe-linux/bullet/2.89-r0/git/examples/ThirdPartyLibs/openvr/bin/linux64/libopenvr_api.so when searching for -lopenvr_api
EXTRA_OECMAKE += "-DBUILD_BULLET2_DEMOS=OFF"

# Fails to find -lBussIK
EXTRA_OECMAKE += "-DBUILD_UNIT_TESTS=OFF"

