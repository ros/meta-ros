# Copyright (c) 2021 LG Electronics, Inc.

# Restricted by MCSL release .deb packages available at
# https://github.com/LORD-MicroStrain/MSCL/releases/tag/v62.0.0
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(.*)', '(^$)', d)}"
COMPATIBLE_MACHINE:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(.*)', '(^$)', d)}"

MSCL_VERSION = "64.2.2"
MSCL_ARCH:x86-64 = "amd64"
MSCL_ARCH:aarch64 = "arm64"
MSCL_ARCH:armv7a = "armhf"
MSCL_ARCH:armv7ve = "armhf"
MSCL_CHECKSUM:x86-64 = "1ac003e26759a510a592b0e149b1afa0fa0dabf537d23780d6c9a4fbf03ff3b2"
MSCL_CHECKSUM:aarch64 = "631eb8aa7ef36e562c22946cb4e0a4616e622deae09879609a90ccf34c13dcc8"
MSCL_CHECKSUM:armv7a = "a2be17b94f9dfede01da83013ceb0e7d330f934eba2d10a3294764f074e32f5b"
MSCL_CHECKSUM:armv7ve = "a2be17b94f9dfede01da83013ceb0e7d330f934eba2d10a3294764f074e32f5b"

# Fetch this with bitbake fetcher instead of
# microstrain_inertial_driver_common/cmake/download_mscl.cmake
# fetching it with curl every time we re-execute do_configure
SRC_URI += "https://github.com/LORD-MicroStrain/MSCL/releases/download/v${MSCL_VERSION}/c++-mscl_${MSCL_VERSION}_${MSCL_ARCH}.deb;subdir=git/MSCL"

SRC_URI[sha256sum] = "${MSCL_CHECKSUM}"

# do_unpack will automatically extract the .deb package, so we don't need dpkg-native for dpkg-deb -x in
# microstrain_inertial_driver_common/cmake/download_mscl.cmake
# DEPENDS += "dpkg-native"
# we can just point MSCL_DIR to already extracted package
EXTRA_OECMAKE += "-DMSCL_DIR=${S}/MSCL/usr/share/c++-mscl"

# MSCL includes bundled prebuilt boost-1.68.0, but libmscl doesn't link with any libboost library:
# microstrain-inertial-driver/2.0.4-1-r0/git$ objdump -x MSCL/usr/share/c++-mscl/libmscl.so | grep NEEDED
#  NEEDED               libstdc++.so.6
#  NEEDED               libm.so.6
#  NEEDED               libgcc_s.so.1
#  NEEDED               libc.so.6
#  NEEDED               ld-linux-armhf.so.3
# so will keep the prebuilt boost in separate package, so that it doesn't get installed in every
# ros-image-world image with microstrain-inertial-driver, if it's really needed in the end
# then users can still explictly add ${PN}-prebuilt-boost into their image
# ERROR: microstrain-inertial-driver-2.0.4-1-r0 do_package: QA Issue: microstrain-inertial-driver: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/galactic/lib/libboost_timer.so.1.68.0
#   /usr/opt/ros/galactic/lib/libboost_chrono.so.1.68.0
#   /usr/opt/ros/galactic/lib/libboost_unit_test_framework.so.1.68.0
#   /usr/opt/ros/galactic/lib/libboost_system.so.1.68.0
#   /usr/opt/ros/galactic/lib/libboost_prg_exec_monitor.so.1.68.0
#   /usr/opt/ros/galactic/lib/libboost_filesystem.so.1.68.0
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# microstrain-inertial-driver: 6 installed and not shipped files. [installed-vs-shipped]
PACKAGES += "${PN}-prebuilt-boost"
FILES:${PN}-prebuilt-boost = "${libdir}/libboost_*"

# ERROR: microstrain-inertial-driver-2.0.4-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package microstrain-inertial-driver contains symlink .so '/usr/opt/ros/galactic/lib/libboost_chrono.so'
# non -dev/-dbg/nativesdk- package microstrain-inertial-driver contains symlink .so '/usr/opt/ros/galactic/lib/libboost_timer.so'
# non -dev/-dbg/nativesdk- package microstrain-inertial-driver contains symlink .so '/usr/opt/ros/galactic/lib/libboost_filesystem.so'
# non -dev/-dbg/nativesdk- package microstrain-inertial-driver contains symlink .so '/usr/opt/ros/galactic/lib/libboost_prg_exec_monitor.so'
# non -dev/-dbg/nativesdk- package microstrain-inertial-driver contains symlink .so '/usr/opt/ros/galactic/lib/libboost_unit_test_framework.so'
# non -dev/-dbg/nativesdk- package microstrain-inertial-driver contains symlink .so '/usr/opt/ros/galactic/lib/libboost_system.so' [dev-so]
INSANE_SKIP:${PN} += "dev-so"

# ERROR: microstrain-inertial-driver-2.0.4-1-r0 do_package_qa: QA Issue:
# microstrain-inertial-driver-prebuilt-boost: found library in wrong location: /usr/opt/ros/galactic/lib/libboost_timer.so.1.68.0
# microstrain-inertial-driver-prebuilt-boost: found library in wrong location: /usr/opt/ros/galactic/lib/libboost_chrono.so.1.68.0
# microstrain-inertial-driver-prebuilt-boost: found library in wrong location: /usr/opt/ros/galactic/lib/libboost_unit_test_framework.so.1.68.0
# microstrain-inertial-driver-prebuilt-boost: found library in wrong location: /usr/opt/ros/galactic/lib/libboost_system.so.1.68.0
# microstrain-inertial-driver-prebuilt-boost: found library in wrong location: /usr/opt/ros/galactic/lib/libboost_prg_exec_monitor.so.1.68.0
# microstrain-inertial-driver-prebuilt-boost: found library in wrong location: /usr/opt/ros/galactic/lib/libboost_filesystem.so.1.68.0 [libdir]
INSANE_SKIP:${PN}-prebuilt-boost += "libdir"

# ERROR: microstrain-inertial-driver-2.0.6-1-r0 do_package_qa: QA Issue: non -staticdev package contains static .a library: microstrain-inertial-driver path '/usr/share/microstrain_inertial_driver/libmicrostrain_inertial_driver.a' [staticdev]
FILES:${PN}-staticdev += "${datadir}/${ROS_BPN}/lib${ROS_BPN}.a"
