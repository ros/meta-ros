# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-hebi-CMakeLists.txt-fix-configure-with-empty-CMAKE_L.patch"

# Supports only 4 values [i686, x86_64, armhf, aarch64], otherwise it ends with default x86_64
# e.g. when CMAKE_LIBRARY_ARCHITECTURE is empty like in our builds
EXTRA_OECMAKE_append_x86 = "-DLIBHEBI_TARGET_ARCHITECTURE=i686"
EXTRA_OECMAKE_append_x86-64 = "-DLIBHEBI_TARGET_ARCHITECTURE=x86_64"
EXTRA_OECMAKE_append_arm = "-DLIBHEBI_TARGET_ARCHITECTURE=armhf"
EXTRA_OECMAKE_append_aarch64 = "-DLIBHEBI_TARGET_ARCHITECTURE=aarch64"

# ERROR: hebi-cpp-api-3.1.1-1-r0 do_package: QA Issue: hebi-cpp-api: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libhebi.so.2.0
#   /usr/opt/ros/melodic/lib/libhebi.so.2
#   /usr/opt/ros/melodic/lib/libhebic++.so.3.1.1
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# hebi-cpp-api: 3 installed and not shipped files. [installed-vs-shipped]
inherit ros_insane_dev_so
