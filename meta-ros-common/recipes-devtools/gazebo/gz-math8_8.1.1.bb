# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "Math classes and functions for robot applications"
DESCRIPTION = "\
    Gazebo Math provides a wide range of functionality, including: \
    * Type-templated pose, matrix, vector, and quaternion classes. \
    * Shape representations along with operators to compute volume, density, size and other properties. \
    * Classes for material properties, mass, inertial, temperature, PID, kmeans, spherical coordinates, and filtering. \
    * Optional Eigen component that converts between a few Eigen and Gazebo Math types. \
"
HOMEPAGE = "https://gazebosim.org/libs/math/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

DEPENDS = "\
    gz-cmake4 \
    gz-cmake4-native \
    gz-utils3 \
    libeigen \
    python3 \
    python3-pybind11 \
    ruby \
    swig-native \
"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=gz-math8"

SRCREV = "d38dc97f7c56e73d828342e3005ed0c4f9497e49"


inherit cmake python3targetconfig

FILES:${PN} += "${libdir}/python/"

BBCLASSEXTEND = "native nativesdk"
