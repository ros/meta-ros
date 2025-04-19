# Copyright (c) 2022 Wind River Systems, Inc.

LICENSE = "BSD-2-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://allow-cxx11-compatibility.patch \
            file://use-NPY_API_SYMBOL_ATTRIBUTE-for-numpy2.patch"

ROS_BUILDTOOL_DEPENDS += "python3-numpy-native"

# Disable the unit tests which fail to find scipy
EXTRA_OECMAKE += "-DBUILD_TESTING_SCIPY=OFF"

inherit python3native

# QA Issue: File /opt/ros/rolling/lib/pkgconfig/eigenpy.pc in package eigenpy-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#-I${RECIPE_SYSROOT_NATIVE}#-I#g" ${D}${ros_prefix}/lib/pkgconfig/eigenpy.pc
}

# ERROR: eigenpy-2.7.14-1-r0 do_package: QA Issue: eigenpy: Files/directories were installed but not shipped in any package:
#  /usr/share/ament_index
#  /usr/share/ament_index/resource_index
#  /usr/share/ament_index/resource_index/packages
#  /usr/share/ament_index/resource_index/packages/eigenpy
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# eigenpy: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"
