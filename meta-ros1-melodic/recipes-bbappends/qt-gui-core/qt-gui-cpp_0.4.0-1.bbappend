# Copyright (c) 2020 LG Electronics, Inc.

# This is needed to set OE_QMAKE_PATH_EXTERNAL_HOST_BINS to resolve:
# | CMake Warning at /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:7 (message):
# |   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# | Call Stack (most recent call first):
# |   src/qt_gui_cpp/CMakeLists.txt:3 (find_package)
# |
# |
# | CMake Error at src/qt_gui_cpp/CMakeLists.txt:37 (qt5_wrap_cpp):
# |   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

# But this still isn't enough, because there are at least 3 more issues:
# 1) PYTHONPATH is set only to ROS specific prefix, e.g.:
#    /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot-native/opt/ros/melodic/lib/python2.7/site-packages
#    so it doesn't find PyQt5
#    Traceback (most recent call last):
#      File "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/opt/ros/melodic/share/python_qt_binding/cmake/sip_configure.py", line 9, in <module>
#          from PyQt5 import QtCore
#          ImportError: No module named PyQt5
# 2) When PYTHONPATH is extended with normal RSS/usr/lib/python2.7/site-packages, it finds PyQt5
#    but it fails to import it, because it's linked with crosscompiled libQt5Core.so.5 which doesn't exist on host
# ldd /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/usr/lib/python2.7/site-packages/PyQt5/QtCore.so
#        linux-vdso.so.1 (0x00007ffff0479000)
#        libQt5Core.so.5 => not found
#        libstdc++.so.6 => /usr/lib/x86_64-linux-gnu/libstdc++.so.6 (0x00007f3ac7d43000)
#        libc.so.6 => /lib/x86_64-linux-gnu/libc.so.6 (0x00007f3ac7952000)
#        libm.so.6 => /lib/x86_64-linux-gnu/libm.so.6 (0x00007f3ac75b4000)
#        /lib64/ld-linux-x86-64.so.2 (0x00007f3ac83a3000)
#        libgcc_s.so.1 => /lib/x86_64-linux-gnu/libgcc_s.so.1 (0x00007f3ac739c000)
#    So it would need python-pyqt5-native, which in turn needs python-sip-native
# 3) Removing QtCore imports from
#    /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/opt/ros/melodic/share/python_qt_binding/cmake/sip_configure.py
#    looks easier, because there aren't many, but in the end it fails as well, because it tries to call target sip (which doesn't exist), it should detect sip_bin from recipe-sysroot-native
#    instead
# ['/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/usr/bin/sip', '-c', '/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/build/sip/qt_gui_cpp_sip', '-b', '/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/build/sip/qt_gui_cpp_sip/pyqtscripting.sbf', '-I', '/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/usr/share/sip/PyQt5', '-w', '', 'qt_gui_cpp.sip']
# Traceback (most recent call last):
#   File "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot/opt/ros/melodic/share/python_qt_binding/cmake/sip_configure.py", line 110, in <module>
#     subprocess.check_call(cmd)
#   File "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot-native/usr/lib/python2.7/subprocess.py", line 185, in check_call
#     retcode = call(*popenargs, **kwargs)
#   File "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot-native/usr/lib/python2.7/subprocess.py", line 172, in call
#     return Popen(*popenargs, **kwargs).wait()
#   File "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot-native/usr/lib/python2.7/subprocess.py", line 394, in __init__
#     errread, errwrite)
#   File "/jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/qt-gui-cpp/0.4.0-1-r0/recipe-sysroot-native/usr/lib/python2.7/subprocess.py", line 1047, in _execute_child
#     raise child_exception
# OSError: [Errno 2] No such file or directory
