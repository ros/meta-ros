# Copyright (c) 2019-2020 LG Electronics, Inc.

DESCRIPTION = "Wrapper around yaml-cpp, it provides a fixed CMake module."

# Don't try to build it inside yaml-cpp-vendor, it doesn't respect -mfloat-abi and breaks build with hard
DEPENDS += "yaml-cpp"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-system-yaml_cpp-if-available-inst.patch"

SYSROOT_DIRS_append = " ${ROS_PREFIX}"

FILES_${PN}-dev_prepend = " \
    ${ROS_PREFIX}/include \
    ${ROS_PREFIX}/lib/cmake \
    ${ROS_PREFIX}/lib/pkgconfig \
"

INSANE_SKIP_${PN} = "dev-so libdir"
