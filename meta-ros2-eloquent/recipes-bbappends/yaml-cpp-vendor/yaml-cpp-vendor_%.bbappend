# Copyright (c) 2019 LG Electronics, Inc.

# This is the tree under which CMakeLists.txt installs the files. Assume it's been done for a good reason.
ROS_PREFIX = "${prefix}/opt/${ROS_BPN}"

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
