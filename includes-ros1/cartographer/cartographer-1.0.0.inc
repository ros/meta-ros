# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/cartographer:"
SRC_URI += " \
    file://cmake.dont.add.isystem.patch \
"

# This is used only to generate documentation so it should
# be native and needs quite a lot of native python dependencies
ROS_BUILD_DEPENDS_remove = "${PYTHON_PN}-sphinx"

DEPENDS += " \
    protobuf-native \
"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS_remove = "ceres-solver"

# Otherwise linking with liblua.a fails with undefined references to dlsym, dlopen, dlerror, dlclose
CXXFLAGS += "-fuse-ld=gold"
