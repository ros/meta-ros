# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-2-Clause"

ROS_BUILDTOOL_DEPENDS:remove = "clang-native-native"

ROS_BUILDTOOL_DEPENDS += " \
    clang-native \
    doxygen-native \
    python3-numpy-native \
"

inherit python3native pkgconfig

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

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-graph-geometry-operator-equal.patch"

# roboplan: CMake Error at recipe-sysroot/opt/ros/kilted/lib/cmake/pinocchio/pinocchioTargets.cmake:144 (message):
#   The imported target "pinocchio::pinocchio_pywrap_default" references the file
#     "/opt/ros/kilted/lib/python3.14/site-packages/pinocchio/pinocchio_pywrap_default.cpython-314-x86_64-linux-gnu.so.4.1.0"
#   but this file does not exist.
# The python modules are exported with an absolute path, make it relative to the install prefix.
do_install:append() {
    sed -i -e 's#"${ros_prefix}/lib/python#"${_IMPORT_PREFIX}/lib/python#g' ${D}${ros_prefix}/lib/cmake/pinocchio/pinocchioTargets*.cmake
}
