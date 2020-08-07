# Copyright (c) 2020 LG Electronics, Inc.

SUMMARY = "A library to benchmark code snippets, similar to unit tests."
HOMEPAGE = "https://github.com/google/benchmark"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "1.5.1+git${SRCPV}"

# matches with tag 1.5.1
SRCREV = "8039b4030795b1c9b8cedb78e3a2a6fb89574b6e"
SRC_URI = "git://github.com/google/benchmark"

S = "${WORKDIR}/git"

# Needs gtest
EXTRA_OECMAKE += "-DBENCHMARK_ENABLE_GTEST_TESTS=OFF -DBENCHMARK_ENABLE_TESTING=OFF"

# Build shared libraries
EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

inherit cmake

# *.cmake files have hardcoded sysroot-s in them.
# webos-rolling-dunfell/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/performance-test-fixture/0.0.2-1-r0/recipe-sysroot/usr/lib/cmake/benchmark/benchmarkTargets.cmake
# points to google-benchmark sysroot (which might be already removed by rm_work)
# INTERFACE_LINK_LIBRARIES "-pthread;/jenkins/home/workspace/jansa/webos-dashing-dunfell/webos-dashing-dunfell/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/google-benchmark/1.5.1+gitAUTOINC+8039b40307-r0/recipe-sysroot/usr/lib/librt.so"
SSTATE_SCAN_FILES_append = " *.cmake"
