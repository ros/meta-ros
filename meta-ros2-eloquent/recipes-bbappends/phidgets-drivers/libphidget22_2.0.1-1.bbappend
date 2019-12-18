# Copyright (c) 2019 LG Electronics, Inc.

# ninja: error: build.ninja:135: bad $-escape (literal $ must be written as $$)
OECMAKE_GENERATOR = "Unix Makefiles"

# WARNING: libphidget22-2.0.1-1-r0 do_populate_lic: libphidget22: No generic license file exists for: LGPL-2 in any provider
# COPYING and COPYING.LESSER in libphidget22-1.4.20190605.tar.gz say GPL-3.0+ and LGPL-3.0+, source files have LGPL-3.0+
# headers only autotools files are GPL-3.0+
LICENSE = "LGPL-3.0+"

# It fetches and patches
# https://www.phidgets.com/downloads/phidget22/libraries/linux/libphidget22/libphidget22-1.4.20190605.tar.gz
# during the build, it should be eventually moved to SRC_URI to use bitbake fetcher and premirror

# It installs everything in hardcoded ${prefix}/opt/libphidget22 prefix
do_configure_prepend() {
    sed -i 's#${CMAKE_INSTALL_PREFIX}/opt/libphidget22/lib/#${libdir}/#g; s#${CMAKE_INSTALL_PREFIX}/opt/libphidget22/include/#${includedir}/#g' ${S}/CMakeLists.txt
    sed -i 's#/opt/libphidget22/lib#/../${libdir}#g; s#/opt/libphidget22/include#/../${includedir}#g' ${S}/cmake/libphidget22-extras.cmake.in
}

do_install_append() {
    # ERROR: libphidget22-2.0.1-1-r0 do_populate_sysroot: QA Issue: libphidget22.pc failed sanity test (tmpdir) in path /jenkins/mjansa/build-ros/ros2-eloquent-thud/tmp-glibc/work/i586-oe-linux/libphidget22/2.0.1-1-r0/sysroot-destdir/usr/lib/pkgconfig [pkgconfig]
    # head -n 1 /jenkins/mjansa/build-ros/ros2-eloquent-thud/tmp-glibc/work/i586-oe-linux/libphidget22/2.0.1-1-r0/sysroot-destdir/usr/lib/pkgconfig/libphidget22.pc
    # prefix=/jenkins/mjansa/build-ros/ros2-eloquent-thud/tmp-glibc/work/i586-oe-linux/libphidget22/2.0.1-1-r0/build/libphidget22_install
    sed -i 's#prefix=${B}/libphidget22_install#prefix=${prefix}#g' ${D}${libdir}/pkgconfig/libphidget22.pc
}

# ERROR: libphidget22-2.0.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: libphidget22 path '/work/i586-oe-linux/libphidget22/2.0.1-1-r0/packages-split/libphidget22/usr/lib/libphidget22.so' [dev-so]
inherit ros-insane
