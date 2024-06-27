# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Revert-cmake-fix-packaging-issue-on-Windows.patch \
    file://0002-Revert-cmake-fix-project-packaging.patch \
"

EXTRA_OECMAKE += "-DPYTHON_EXECUTABLE=${PYTHON}"

# | CMake Error at /jenkins/mjansa/build/ros/ros1-noetic-hardknott/tmp-glibc/work/core2-64-oe-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.18/Modules/FindPackageHandleStandardArgs.cmake:165 (message):
# |   Could NOT find Python3 (missing: Python3_INCLUDE_DIRS Python3_LIBRARIES
# |   Development Development.Module Development.Embed) (found version "3.6.9")
# | Call Stack (most recent call first):
# |   /jenkins/mjansa/build/ros/ros1-noetic-hardknott/tmp-glibc/work/core2-64-oe-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.18/Modules/FindPackageHandleStandardArgs.cmake:458 (_FPHSA_FAILURE_MESSAGE)
# |   /jenkins/mjansa/build/ros/ros1-noetic-hardknott/tmp-glibc/work/core2-64-oe-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.18/Modules/FindPython/Support.cmake:2984 (find_package_handle_standard_args)
# |   /jenkins/mjansa/build/ros/ros1-noetic-hardknott/tmp-glibc/work/core2-64-oe-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.18/Modules/FindPython3.cmake:389 (include)
# |   cmake/python.cmake:92 (FIND_PACKAGE)
# |   CMakeLists.txt:61 (FINDPYTHON)
inherit python3native

# | -- checking for numpy
# | CMake Error at cmake/python.cmake:482 (MESSAGE):
# |   Failed to detect numpy
# | Call Stack (most recent call first):
# |   CMakeLists.txt:62 (FIND_NUMPY)
DEPENDS += "python3-numpy-native"

do_install:append() {
    # Fix paths in .pc file
    # Libs: -L${libdir}  -leigenpy -L/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot/usr/lib -lboost_python37
    # Cflags:  -I${includedir} -I/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot/usr/include -I/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot/usr/include/python2.7 -I/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot-native/usr/lib/python2.7/site-packages/numpy/core/include
    # '' between $ and { is used to prevent pkg-config variables to be expanded by bitbake
    sed 's#-L${RECIPE_SYSROOT}${libdir} ##g; s#-I${RECIPE_SYSROOT}${includedir} ##g; s#-I${RECIPE_SYSROOT}${includedir}/python#-I$''{includedir}/python#g; s#-I${RECIPE_SYSROOT_NATIVE}${libdir}/python#-I$''{libdir}/python#g; s#-I${RECIPE_SYSROOT}${libdir}/python#-I''${libdir}/python#g' -i ${D}${libdir}/pkgconfig/eigenpy.pc
}
