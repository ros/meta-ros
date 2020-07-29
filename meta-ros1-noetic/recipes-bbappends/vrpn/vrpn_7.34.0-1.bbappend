# Copyright (c) 2020 LG Electronics, Inc.

# Otherwise picks native python instead of the target one and fails with:
# | /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot-native/usr/bin/arm-webos-linux-gnueabi/arm-webos-linux-gnueabi-g++  -DCALLBACK_CALL="" -DVRPN_USING_CMAKE=\"/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/build/vrpn_Configure.h\" -Dvrpn_python_EXPORTS -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/submodules/jsoncpp/include -I. -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/atmellib -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/quat -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot/usr/include -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot-native/usr/include/python3.7m -I/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/python -march=armv7ve -mthumb -mfpu=neon-vfpv4 -mfloat-abi=hard -mcpu=cortex-a7 -fstack-protector-strong  -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security -Werror=return-type  --sysroot=/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot  -O2 -pipe -g -feliminate-unused-debug-types -fdebug-prefix-map=/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0=/usr/src/debug/vrpn/7.34.0-1-r0 -fdebug-prefix-map=/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot= -fdebug-prefix-map=/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot-native=  -fvisibility-inlines-hidden   -march=armv7ve -mthumb -mfpu=neon-vfpv4 -mfloat-abi=hard -mcpu=cortex-a7 -fstack-protector-strong  -D_FORTIFY_SOURCE=2 -Wformat -Wformat-security -Werror=format-security -Werror=return-type  --sysroot=/jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot -fPIC -fPIC -MD -MT python/CMakeFiles/vrpn-python.dir/receiver/receiver.cpp.o -MF python/CMakeFiles/vrpn-python.dir/receiver/receiver.cpp.o.d -o python/CMakeFiles/vrpn-python.dir/receiver/receiver.cpp.o -c /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/python/receiver/receiver.cpp
# | In file included from /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot-native/usr/include/python3.7m/Python.h:63,
# |                  from /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/python/include/interface.hpp:4,
# |                  from /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/git/python/receiver/receiver.cpp:1:
# | /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot-native/usr/include/python3.7m/pyport.h:699:2: error: #error "LONG_BIT definition appears wrong for platform (bad gcc/glibc config?)."
# |  #error "LONG_BIT definition appears wrong for platform (bad gcc/glibc config?)."
# |   ^~~~~
#
# Because it will prefer native 3.7 version:
# -- Found PythonLibs: /jenkins/mjansa/build-ros/webos-melodic-thud/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/vrpn/7.34.0-1-r0/recipe-sysroot-native/usr/lib/libpython3.7m.so (found version "3.7.5")
# instead of the target 2.7:
# ../recipe-sysroot/usr/lib/libpython2.7.so
EXTRA_OECMAKE += " \
    -DVRPN_BUILD_PYTHON=OFF \
    -DVRPN_BUILD_PYTHON_HANDCODED_3X=OFF \
    -DVRPN_BUILD_PYTHON_HANDCODED_2X=OFF \
"

do_install_append () {
    if [ -d ${D}${prefix}${sysconfdir} ] ; then
        mv ${D}${prefix}${sysconfdir} ${D}${sysconfdir}
    fi
}

# ERROR: vrpn-7.34.0-1-r0 do_package: QA Issue: vrpn: Files/directories were installed but not shipped in any package:
#  /usr/etc
#  /usr/etc/vrpn.cfg
#  /usr/share/quatlib
#  /usr/share/quatlib/cmake
#  /usr/share/quatlib/cmake/quatlibConfig.cmake
#  /usr/share/vrpn-07.34
#  /usr/share/vrpn-07.34/vrpn.cfg.sample
FILES_${PN} += " \
    ${datadir}/quatlib \
    ${datadir}/vrpn-07.34 \
"
