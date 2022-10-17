# Copyright (c) 2020 LG Electronics, Inc.

require orocos-kdl.inc

DESCRIPTION = "The python bindings PyKDL for the Kinematics and Dynamics Library (KDL), distributed by the Orocos Project."
SECTION = "devel"
LICENSE = "LGPL-2.1-or-later"
#LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=11;endline=11;md5=27620a6c8e31b44ce8d87ab1e2127522"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=46ee8693f40a89a31023e97ae17ecf19"

SRC_URI += "file://0001-Declare-assignment-operator-private-for-SIP-Closes-2.patch;patchdir=.. \
    file://0002-CMakeLists.txt-use-python3.patch;patchdir=.. \
"
S = "${WORKDIR}/git/python_orocos_kdl"

inherit cmake python3native python3-dir

DEPENDS += "orocos-kdl sip3-native sip3 libeigen"

# sip3-native from meta-oe, doesn't provide sipconfig/sipbuild used by FindSIP.cmake/FindSIP.py
# https://riverbankcomputing.com/pipermail/pyqt/2019-November/042312.html
# https://github.com/qgis/QGIS/commit/33b58dd7e8d813425624d302b88a8c158c47eac3
# setting SIP_VERSION just to disable this FindSIP, but then we need to set SIP_EXECUTABLE etc
EXTRA_OECMAKE += "-DSIP_VERSION='4.19' -DSIP_EXECUTABLE=sip"

# the orocos_kdl build does include FindEigen3.cmake:
# orocos_kdl/CMakeLists.txt:  include(${PROJ_SOURCE_DIR}/config/FindEigen3.cmake)
# but here we're building only the python_orocos_kdl subdirectory which doesn't
# include it, set EIGEN3_INCLUDE_DIR manually
EXTRA_OECMAKE += "-DEIGEN3_INCLUDE_DIR=${STAGING_INCDIR}/eigen3"
# and python_orocos_kdl subdirectory also doesn't use EIGEN3_INCLUDE_DIR, lets mis-use SIP_INCLUDE_DIR to pass that
# orocos_kdl/CMakeLists.txt:  set(Eigen_INCLUDE_DIR "${EIGEN3_INCLUDE_DIR}")
# orocos_kdl/KDLConfig.cmake.in:set(orocos_kdl_INCLUDE_DIRS "${CMAKE_CURRENT_LIST_DIR}/../../../include;@Boost_INCLUDE_DIRS@;@Eigen_INCLUDE_DIR@")
EXTRA_OECMAKE += "-DSIP_INCLUDE_DIR=${STAGING_INCDIR}/eigen3"

# Hopefully this will get a bit simpler with 1.4.1 version which dropped sip version:
# https://github.com/orocos/orocos_kinematics_dynamics/commit/aa395abf95726ca3f81e99b6599ba7de26413588

# /usr/share/python_orocos_kdl/package.xml
FILES:${PN}-dev += "${datadir}/python_orocos_kdl"

# /usr/lib/python3.9/site-packages/PyKDL.so
FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}"
