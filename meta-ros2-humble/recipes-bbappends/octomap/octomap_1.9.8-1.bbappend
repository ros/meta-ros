# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# error: 'template<class _Category, class _Tp, class _Distance, class _Pointer, class _Reference> struct std::iterator' is deprecated [-Werror=deprecated-declarations]
# error: template-id not allowed for constructor in C++20 [-Werror=template-id-cdtor]
CXXFLAGS += "-Wno-error=deprecated-declarations -Wno-error=template-id-cdtor"

# ERROR: octomap-1.9.7-1-r0 do_package: QA Issue: octomap: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/octomap
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# octomap: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

# ERROR: octomap-1.9.7-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package octomap contains symlink .so '/usr/lib/liboctomath.so'
# non -dev/-dbg/nativesdk- package octomap contains symlink .so '/usr/lib/liboctomap.so' [dev-so]
inherit ros_insane_dev_so
