# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY = "Library to work around various flaws in the C++ STL allocator model"
HOMEPAGE = "https://github.com/foonathan/memory"
SECTION = "devel"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=416a165d541fc79ae4852280a9ecb39f"

PV = "0.6.2+git${SRCPV}"

SRCREV_FORMAT = "main"
SRCREV_main = "8f6a027d473f9b4796509158962d8ddf89fbe086"
SRCREV_comp = "cf13bff238397aab0d8c49b7f6263233cf8a2396"
SRC_URI = "git://github.com/foonathan/memory.git;protocol=https;name=main \
    git://github.com/foonathan/compatibility.git;protocol=https;name=comp;destsuffix=git/cmake/comp \
"
S = "${WORKDIR}/git"

DEPENDS = "qemu-native"
inherit cmake qemu

# Using whole cmdline with:
# EXTRA_OECMAKE = '-DCMAKE_CROSSCOMPILING_EMULATOR="${@qemu_wrapper_cmdline(d, '${STAGING_DIR_TARGET}', ['${B}', '${STAGING_DIR_TARGET}/${base_libdir}'])}"'
# Doesn't work, because
# src/CMakeLists.txt:            COMMAND ${CMAKE_CROSSCOMPILING_EMULATOR} $<TARGET_FILE:foonathan_memory_node_size_debugger> --code --alignof "FOONATHAN_ALIGNOF(T)" ${CMAKE_CURRENT_BINARY_DIR}/container_node_sizes_impl.hpp
# wrapps it in extra quotes and then shell fails to start with:
# | cd /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/build/src && "PSEUDO_UNLOAD=1 qemu-arm -r 3.2.0  -L /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/recipe-sysroot -E LD_LIBRARY_PATH=/jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/build:/jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/recipe-sysroot//lib" /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/build/tool/nodesize_dbg --code --alignof "FOONATHAN_ALIGNOF(T)" /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/build/src/container_node_sizes_impl.hpp
# | /bin/sh: 1: PSEUDO_UNLOAD=1 qemu-arm -r 3.2.0  -L /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/recipe-sysroot -E LD_LIBRARY_PATH=/jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/build:/jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory/0.6.2+gitAUTOINC+8f6a027d47-r0/recipe-sysroot//lib: not found
EXTRA_OECMAKE = '-DCMAKE_CROSSCOMPILING_EMULATOR="${@qemu_target_binary(d)}"'

# Add -fPIC, otherwise fastrtps fails to link with static libfoonathan_memory-0.6.2.a
# | /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/fastrtps/1.9.3-1-r0/recipe-sysroot-native/usr/bin/arm-oe-linux-gnueabi/../../libexec/arm-oe-linux-gnueabi/gcc/arm-oe-linux-gnueabi/8.2.0/ld: /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/fastrtps/1.9.3-1-r0/recipe-sysroot/usr/lib/libfoonathan_memory-0.6.2.a(error.cpp.o): relocation R_ARM_THM_MOVW_ABS_NC against `a local symbol' can not be used when making a shared object; recompile with -fPIC
CXXFLAGS += "-fPIC"
# and similarly for native
# fastrtps-native/1.9.3-1-r0/recipe-sysroot-native/usr/lib/libfoonathan_memory-0.6.2.a(virtual_memory.cpp.o): relocation R_X86_64_PC32 against symbol `_ZN9foonathan6memory24virtual_memory_page_sizeE' can not be used when making a shared object; recompile with -fPIC
BUILD_CXXFLAGS += "-fPIC"

# We need to stage nodesize_dbg binary, because foonathan_memory-config.cmake references it and without this foonathan-memory-vendor fails with:
# | CMake Error at /jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory-vendor/0.3.0-1-r0/recipe-sysroot/usr/share/foonathan_memory/cmake/foonathan_memory-config.cmake:83 (message):
# |   The imported target "foonathan_memory_node_size_debugger" references the
# |   file
# |
# |      "/jenkins/mjansa/build-ros-thud-eloquent/BUILD/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/foonathan-memory-vendor/0.3.0-1-r0/recipe-sysroot/usr/bin/nodesize_dbg"
# |
# |   but this file does not exist.  Possible reasons include:
# |
# |   * The file was deleted, renamed, or moved to another location.
#
SYSROOT_DIRS_append = " ${bindir}"

FILES_${PN}-dev += "${datadir}/foonathan_memory/cmake"
FILES_${PN}-doc += "${datadir}/foonathan_memory"

BBCLASSEXTEND = "native"
