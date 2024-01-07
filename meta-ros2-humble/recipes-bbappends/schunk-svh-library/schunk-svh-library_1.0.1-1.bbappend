# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: schunk-svh-library: Files/directories were installed but not shipped in any package:
#  /usr/share/ament_index
#  /usr/share/ament_index/resource_index
#  /usr/share/ament_index/resource_index/packages
#  /usr/share/ament_index/resource_index/packages/schunk_svh_library
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# schunk-svh-library: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/ament_index/resource_index/packages/schunk_svh_library"

# ERROR: schunk-svh-library-1.0.1-1-r0 do_package_qa: QA Issue: schunk-svh-library: /usr/lib/libsvh-serial.so contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${libdir}/*.so
}
