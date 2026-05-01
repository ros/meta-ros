# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023-2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# tag: release/lyrical/qt_gui_cpp/2.10.7-3
SRCREV = "e5cde356eaf3783c8e3ed44923623792adef552d"

# inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-qmake', '', d)}

inherit python3targetconfig

DEPENDS += "python3-pip-native"

EXTRA_OECMAKE += ' -DPYQT_BINDINGS_DIR="${STAGING_DIR_TARGET}/${libdir}/${PYTHON_DIR}/site-packages/PyQt6/bindings"'

#FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
#SRC_URI += "file://use-cmake-target-libraries.patch"

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# | -- Found PythonLibs: ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/lib/libpython3.8.so (found suitable version "3.8.2", minimum required is "3.8")
# | CMake Warning at ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
# |   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# | Call Stack (most recent call first):
# |   src/qt_gui_cpp/CMakeLists.txt:3 (find_package)
# |
# |
# | CMake Error at src/qt_gui_cpp/CMakeLists.txt:35 (qt5_wrap_cpp):
# |   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

ROS_BUILD_DEPENDS += " python3-pyqt6"

# | CMake Warning at ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/share/python_qt_binding/cmake/sip_helper.cmake:27 (message):
# |   SIP binding generator NOT available.
ROS_BUILDTOOL_DEPENDS += "python3-pyqt-builder-native sip-native"

# | CMake Error:
# |   Running
# |    'ninja' '-C' '.../qt-gui-cpp/2.2.2-1-r0/build' '-t' 'recompact'
# |   failed with:
# |    ninja: error: build.ninja:511: bad $-escape (literal $ must be written as $$)
#
# This is caused by sip_helper.cmake from python_qt_binding containing a
# hard-coded command that violates ninja syntax: cd <DIR> && $(MAKE)
OECMAKE_GENERATOR = "Unix Makefiles"

do_compile:append() {
    sed -i -e "s#${WORKDIR}##g" ${B}/sip/qt_gui_cpp_sip/libqt_gui_cpp_sip/siplibqt_gui_cpp_sippart0.cpp
}
