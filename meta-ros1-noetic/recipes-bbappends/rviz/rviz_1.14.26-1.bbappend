# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

inherit python3targetconfig

# | CMake Warning at rviz/1.14.25-1-r0/recipe-sysroot/opt/ros/noetic/share/python_qt_binding/cmake/sip_helper.cmake:28 (message):
# |   SIP binding generator NOT available.
ROS_BUILDTOOL_DEPENDS += "python3-pyqt5-native sip-native"

# | CMake Warning at rviz/1.14.25-1-r0/recipe-sysroot/opt/ros/noetic/share/python_qt_binding/cmake/sip_helper.cmake:28 (message):
# |   SIP binding generator NOT available.
DEPENDS += "python3-pyqt5-native sip-native"

export SIP_PROJECT_INCLUDE_DIRS = "${STAGING_DIR_TARGET}/${libdir}/${PYTHON_DIR}/site-packages/PyQt5/bindings"

# | CMake Error at src/rviz/CMakeLists.txt:23 (add_library):
# |   Target "rviz" links to target "Qt5::Widgets" but the target was not found.
# |   Perhaps a find_package() call is missing for an IMPORTED target, or an
# |   ALIAS target is missing?
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}

# This is needed to ensure that the qt.conf is generated to find include directories:
# | In file included from siplibqt_gui_cpp_sipQList0101qt_gui_cppPluginProvider.cpp:7:
# | sipAPIlibqt_gui_cpp_sip.h:12:10: fatal error: QMetaType: No such file or directory
# |    12 | #include <QMetaType>
# |       |          ^~~~~~~~~~~
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'qmake5_base', '', d)}

# | CMake Error:
# |   Running
# |    'ninja' '-C' '.../qt-gui-cpp/2.2.2-1-r0/build' '-t' 'recompact'
# |   failed with:
# |    ninja: error: build.ninja:511: bad $-escape (literal $ must be written as $$)
#
# This is caused by sip_helper.cmake from python_qt_binding containing a
# hard-coded command that violates ninja syntax: cd <DIR> && $(MAKE)
OECMAKE_GENERATOR = "Unix Makefiles"

# ERROR: QA Issue: package rviz contains bad RPATH .../rviz/1.14.25-1-r0/devel/lib
#        in file .../rviz/1.14.25-1-r0/packages-split/rviz/opt/ros/noetic/lib/python3.10/site-packages/rviz/librviz_sip.so
#do_install:append() {
#    chrpath --delete ${D}${ros_libdir}/${PYTHON_DIR}/site-packages/rviz/librviz_sip*${SOLIBS}
#}
