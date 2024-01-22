# Copyright (c) 2023 Wind River Systems, Inc.

LIC_FILES_CHKSUM = "file://tinyspline/LICENSE;md5=c610fed0222ab3c9f2b3e20448a3b3fc"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
  git://github.com/ros2-gbp/tinyspline_vendor-release;name=release;${ROS_BRANCH};protocol=https \
  git://github.com/msteinbeck/tinyspline.git;name=upstream;destsuffix=git/tinyspline;branch=master;protocol=https \
  file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch \
  file://0002-fix-pkgconfig-files.patch \
"

SRCREV_release = "4827b82ab911131c8ea0ee375aab949c5ee06dc5"
SRCREV_upstream = "5f0e8fad34e86771cfae3dac4beef5f1858d5610"
SRCREV_FORMAT = "release_upstream"

DEPENDS += "swig-native lua-native"
