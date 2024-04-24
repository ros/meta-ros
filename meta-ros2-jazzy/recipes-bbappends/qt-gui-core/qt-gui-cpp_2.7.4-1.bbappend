# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

inherit python3native

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
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

# | CMake Warning at ros2-foxy-dunfell/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/1.0.8-1-r0/recipe-sysroot/usr/share/python_qt_binding/cmake/sip_helper.cmake:27 (message):
# |   SIP binding generator NOT available.
DEPENDS += "python3-pyqt5-native sip3-native"

# | CMake Error:
# |   Running
# |    'ninja' '-C' '.../qt-gui-cpp/2.2.2-1-r0/build' '-t' 'recompact'
# |   failed with:
# |    ninja: error: build.ninja:511: bad $-escape (literal $ must be written as $$)
#
# This is caused by sip_helper.cmake from python_qt_binding containing a
# hard-coded command that violates ninja syntax: cd <DIR> && $(MAKE)
OECMAKE_GENERATOR = "Unix Makefiles"

do_compile:prepend () {
    cp ${STAGING_LIBDIR}/${PYTHON_DIR}${PYTHON_ABI}/site-packages/sipconfig.py ${STAGING_DATADIR}/python_qt_binding/cmake/
    sed -i -e "s|--sysroot |--sysroot ${STAGING_DIR_TARGET}|g" ${STAGING_DATADIR}/python_qt_binding/cmake/sipconfig.py
    sed -i -e "s|--sysroot=[^ ']*|--sysroot=${STAGING_DIR_TARGET}|g" ${STAGING_DATADIR}/python_qt_binding/cmake/sipconfig.py
    sed -i -e "s|\('[a-z_]*_dir': *'\)\([^']*',\)|\1${STAGING_DIR_TARGET}\2|g" ${STAGING_DATADIR}/python_qt_binding/cmake/sipconfig.py
    sed -i -e "s|\('sip_bin': *'\)\(/usr/bin/sip',\)|\1${STAGING_DIR_NATIVE}\2|" ${STAGING_DATADIR}/python_qt_binding/cmake/sipconfig.py
}

do_install:append () {
    chrpath --delete ${D}${libdir}/${PYTHON_DIR}/site-packages/qt_gui_cpp/libqt_gui_cpp_sip.so
}
