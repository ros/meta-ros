# Copyright (c) 2020 LG Electronics, Inc.

# in thud it incorrectly detects python dependencies
inherit pythonnative
DEPENDS += "python-numpy-native"

do_install_append() {
    # Fix paths in .pc file
    # Libs: -L${libdir}  -leigenpy -L/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot/usr/lib -lboost_python37
    # Cflags:  -I${includedir} -I/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot/usr/include -I/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot/usr/include/python2.7 -I/jenkins/mjansa/build/ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/eigenpy/1.6.9-1-r0/recipe-sysroot-native/usr/lib/python2.7/site-packages/numpy/core/include
    # '' between $ and { is used to prevent pkg-config variables to be expanded by bitbake
    sed 's#-L${RECIPE_SYSROOT}${libdir} ##g; s#-I${RECIPE_SYSROOT}${includedir} ##g; s#-I${RECIPE_SYSROOT}${includedir}/python#-I$''{includedir}/python#g; s#-I${RECIPE_SYSROOT_NATIVE}${libdir}/python#-I$''{libdir}/python#g; s#-I${RECIPE_SYSROOT}${libdir}/python#-I''${libdir}/python#g' -i ${D}${libdir}/pkgconfig/eigenpy.pc
}
