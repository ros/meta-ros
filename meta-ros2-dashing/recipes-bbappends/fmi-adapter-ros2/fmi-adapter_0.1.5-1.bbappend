# Copyright (c) 2019 LG Electronics, Inc.

# build external project first (It seems that dependency logic is weird.)
cmake_do_compile_prepend() {
    cmake_runcmake_build --target FMILibraryProject
}

# Don't test the external project because of we are in cross-compiling
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " file://0001-Don-t-test-external-project.patch"
