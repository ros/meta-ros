# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: libfranka-0.7.1-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: libfranka path '/work/aarch64-oe-linux/libfranka/0.7.1-1-r0/packages-split/libfranka/usr/lib/libfranka.so' [dev-so]
inherit ros_insane_dev_so

# WARNING: libfranka-0.7.1-1-r0 do_package: QA Issue: libfranka: Files/directories were installed but not shipped in any package:
#   /usr/share/franka
#   /usr/share/franka/cmake
#   /usr/share/franka/cmake/FrankaConfig.cmake
#   /usr/share/franka/cmake/FrankaTargets.cmake
#   /usr/share/franka/cmake/FrankaConfigVersion.cmake
#   /usr/share/franka/cmake/FrankaTargets-noconfig.cmake
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# libfranka: 6 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${datadir}/franka"
