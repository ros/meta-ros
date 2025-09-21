# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-2-Clause"

ROS_BUILDTOOL_DEPENDS:remove = "clang-native-native"

ROS_BUILDTOOL_DEPENDS += "\
    clang-native \
    doxygen-native \
    python3-numpy-native \
"

inherit python3native pkgconfig

# QA Issue: File /opt/ros/rolling/lib/pkgconfig/pinocchiopy.pc in package pinocchio-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#-I${RECIPE_SYSROOT_NATIVE}#-I#g" ${D}${ros_prefix}/lib/pkgconfig/pinocchiopy.pc
}

# ERROR: pinocchio-2.6.17-1-r0 do_package: QA Issue: pinocchio: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/pinocchio
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# pinocchio: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/ament_index/resource_index/packages/pinocchio"

# ERROR: pinocchio-2.6.17-4-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package pinocchio contains symlink .so '/usr/lib/libpinocchio.so'
# non -dev/-dbg/nativesdk- package pinocchio contains symlink .so '/usr/lib/python3.11/site-packages/pinocchio/pinocchio_pywrap.cpython-311-x86_64-linux-gnu.so' [dev-so]
inherit ros_insane_dev_so
