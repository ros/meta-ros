# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += " \
    ament-cmake \
    ament-cmake-core \
    ament-cmake-libraries \
    ament-cmake-export-definitions \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-include-directories \
    ament-cmake-test \
    ament-cmake-version \
    ament-package-native \
    eigen3-cmake-module \
    python3-catkin-pkg-native \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    rosidl-typesupport-c \
    rosidl-runtime-cpp \
"

inherit python3native

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# | -- Found Ceres version: 2.0.0 installed in: /jenkins/mjansa/build/ros/webos-rolling-hardknott/tmp-glibc/work/qemux86-webos-linux/rmf-traffic-editor/1.3.0-3-r0/recipe-sysroot/usr with components: [EigenSparse, SparseLinearAlgebraLibrary, LAPACK, SuiteSparse, CXSparse, SchurSpecializations, Multithreading]
# CMake Warning at /jenkins/mjansa/build/ros/webos-rolling-hardknott/tmp-glibc/work/qemux86-webos-linux/rmf-traffic-editor/1.3.0-3-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# Call Stack (most recent call first):
#   CMakeLists.txt:13 (find_package)
#
# but it also needs widgets to be enabled in qtbase PACKAGECONFIG
#inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}
