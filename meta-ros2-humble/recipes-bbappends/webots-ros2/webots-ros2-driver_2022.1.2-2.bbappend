# Copyright (c) 2021 LG Electronics, Inc.

# The repo contains prebuilt binaries only for x86-64 (darwin, msys and linux):
# webots-ros2-driver/1.1.0-1-r0/git$ file webots/lib/darwin19/lib*
# webots/lib/darwin19/libcar.dylib:           Mach-O 64-bit x86_64 dynamically linked shared library, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|NO_REEXPORTED_DYLIBS>
# webots/lib/darwin19/libController.dylib:    Mach-O 64-bit x86_64 dynamically linked shared library, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|NO_REEXPORTED_DYLIBS>
# webots/lib/darwin19/libCppCar.dylib:        Mach-O 64-bit x86_64 dynamically linked shared library, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|NO_REEXPORTED_DYLIBS>
# webots/lib/darwin19/libCppController.dylib: Mach-O 64-bit x86_64 dynamically linked shared library, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|WEAK_DEFINES|BINDS_TO_WEAK|NO_REEXPORTED_DYLIBS>
# webots/lib/darwin19/libCppDriver.dylib:     Mach-O 64-bit x86_64 dynamically linked shared library, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|WEAK_DEFINES|BINDS_TO_WEAK|NO_REEXPORTED_DYLIBS>
# webots/lib/darwin19/libdriver.dylib:        Mach-O 64-bit x86_64 dynamically linked shared library, flags:<NOUNDEFS|DYLDLINK|TWOLEVEL|NO_REEXPORTED_DYLIBS>

# webots-ros2-driver/1.1.0-1-r0/git$ file webots/lib/msys/*
# webots/lib/msys/car.dll:            PE32+ executable (DLL) (console) x86-64 (stripped to external PDB), for MS Windows
# webots/lib/msys/car.lib:            current ar archive
# webots/lib/msys/Controller.dll:     PE32+ executable (DLL) (GUI) x86-64 (stripped to external PDB), for MS Windows
# webots/lib/msys/Controller.lib:     current ar archive
# webots/lib/msys/CppCar.dll:         PE32+ executable (DLL) (console) x86-64 (stripped to external PDB), for MS Windows
# webots/lib/msys/CppController.dll:  PE32+ executable (DLL) (console) x86-64, for MS Windows
# webots/lib/msys/CppDriver.dll:      PE32+ executable (DLL) (console) x86-64 (stripped to external PDB), for MS Windows
# webots/lib/msys/driver.dll:         PE32+ executable (DLL) (console) x86-64 (stripped to external PDB), for MS Windows
# webots/lib/msys/driver.lib:         current ar archive
# webots/lib/msys/libController.a:    current ar archive
# webots/lib/msys/libCppController.a: current ar archive

# webots-ros2-driver/1.1.0-1-r0/git$ file webots/lib/linux-gnu/*
# webots/lib/linux-gnu/libcar.so:           ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=888d9eb9758c2fabd82eba3d45845b77a77e0074, stripped
# webots/lib/linux-gnu/libController.so:    ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=9244e95f4ac13e58c2c4585c1c0080d0c5b0ee0d, stripped
# webots/lib/linux-gnu/libCppCar.so:        ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=b83c4adb0426f65ac3767f408f0ff6fb30d8759d, stripped
# webots/lib/linux-gnu/libCppController.so: ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=1895cbf8c898fa8f4fbd91c00d0a2576f4224d24, not stripped
# webots/lib/linux-gnu/libCppDriver.so:     ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=ced9c652fee7d1868ff445267b9210cd4c3d4d41, stripped
# webots/lib/linux-gnu/libdriver.so:        ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=d17d864ddd3c32395f524640c679e9f148c63904, stripped

# so it fails for other architectures like x86:
# /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/recipe-sysroot-native/usr/bin/i686-webos-linux/../../libexec/i686-webos-linux/gcc/i686-webos-linux/11.2.0/ld: warning: skipping incompatible /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/git/webots/lib/linux-gnu/libController.so while searching for Controller
# /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/recipe-sysroot-native/usr/bin/i686-webos-linux/../../libexec/i686-webos-linux/gcc/i686-webos-linux/11.2.0/ld: error: cannot find -lController
# /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/recipe-sysroot-native/usr/bin/i686-webos-linux/../../libexec/i686-webos-linux/gcc/i686-webos-linux/11.2.0/ld: warning: skipping incompatible /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/git/webots/lib/linux-gnu/libCppController.so while searching for CppController
# /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/recipe-sysroot-native/usr/bin/i686-webos-linux/../../libexec/i686-webos-linux/gcc/i686-webos-linux/11.2.0/ld: error: cannot find -lCppController
# /usr/src/debug/webots-ros2-driver/1.1.0-1-r0/git/webots/include/cpp/webots/Supervisor.hpp:27: error: undefined reference to 'webots::Robot::Robot()'
# /usr/src/debug/webots-ros2-driver/1.1.0-1-r0/git/webots/include/cpp/webots/Supervisor.hpp:27: error: undefined reference to 'vtable for webots::Supervisor'
# /jenkins/mjansa/build/ros/webos-rolling-honister/tmp-glibc/work/qemux86-webos-linux/webots-ros2-driver/1.1.0-1-r0/recipe-sysroot-native/usr/bin/i686-webos-linux/../../libexec/i686-webos-linux/gcc/i686-webos-linux/11.2.0/ld: the vtable symbol may be undefined because the class is missing its key function
# ...
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"

# The prebuilt binaries are already stripped
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_package: QA Issue: File '/usr/lib/libcar.so' from webots-ros2-driver was already stripped, this will prevent future debugging! [already-stripped]
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_populate_sysroot: File '/usr/lib/libcar.so' from webots-ros2-driver was already stripped, this will prevent future debugging!
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_package: QA Issue: File '/usr/lib/libController.so' from webots-ros2-driver was already stripped, this will prevent future debugging! [already-stripped]
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_populate_sysroot: File '/usr/lib/libController.so' from webots-ros2-driver was already stripped, this will prevent future debugging!
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_package: QA Issue: File '/usr/lib/libCppCar.so' from webots-ros2-driver was already stripped, this will prevent future debugging! [already-stripped]
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_populate_sysroot: File '/usr/lib/libCppCar.so' from webots-ros2-driver was already stripped, this will prevent future debugging!
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_package: QA Issue: File '/usr/lib/libCppDriver.so' from webots-ros2-driver was already stripped, this will prevent future debugging! [already-stripped]
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_populate_sysroot: File '/usr/lib/libCppDriver.so' from webots-ros2-driver was already stripped, this will prevent future debugging!
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_package: QA Issue: File '/usr/lib/libdriver.so' from webots-ros2-driver was already stripped, this will prevent future debugging! [already-stripped]
# WARNING: webots-ros2-driver-1.1.0-1-r0 do_populate_sysroot: File '/usr/lib/libdriver.so' from webots-ros2-driver was already stripped, this will prevent future debugging!
INSANE_SKIP:${PN} += "already-stripped"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-don-t-require-python-exact-version-to.patch \
    file://0002-CMakeLists.txt-use-prebuilt-libraries-from-python39-.patch \
    file://0003-CMakeLists-search-for-Python3-before-using-PYTHON_VE.patch \
    file://0002-Fix-build-with-gcc-10.patch \
"
