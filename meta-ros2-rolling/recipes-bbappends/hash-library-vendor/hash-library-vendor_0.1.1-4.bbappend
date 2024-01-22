# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Error at .../hash-library-vendor/0.1.1-3-r0/recipe-sysroot-native/usr/share/ament_cmake_auto/cmake/ament_auto_add_library.cmake:42 (message):
#   ament_auto_add_library() called without any source files and without a
#   DIRECTORY argument                                                                                                                                                                                           
# Call Stack (most recent call first):
#   CMakeLists.txt:23 (ament_auto_add_library)
#   CMakeLists.txt:37 (build_vendor_package)                                                                                                                                                                     
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
  git://github.com/ros2-gbp/hash_library_vendor-release;name=release;${ROS_BRANCH};protocol=https \
  git://github.com/stbrumme/hash-library.git;name=upstream;destsuffix=git/_deps/hash_library_vendor-src;branch=master;protocol=https \
  file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch \
"

SRCREV_release = "b535529aa09eb56e19bd913543c383e82fbfa899"
SRCREV_upstream = "70cc93763d49a24c4536c7f0a23248f9b40e30f5"
SRCREV_FORMAT = "release_upstream"
