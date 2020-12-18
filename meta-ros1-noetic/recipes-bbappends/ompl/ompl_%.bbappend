# Copyright (c) 2019-2020 LG Electronics, Inc.

inherit ros_insane_dev_so

DEPENDS_append_class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: ompl-1.4.2-5-r0 do_package_qa: QA Issue: ompl: /work/core2-64-oe-linux/ompl/1.4.2-5-r0/packages-split/ompl/usr/lib/libompl.so.1.4.2 contains probably-redundant RPATH /usr/lib [useless-rpaths]
do_install_append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}

# ERROR: ompl-1.5.1-1-r0 do_package: QA Issue: ompl: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/ompl
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ompl: 4 installed and not shipped files. [installed-vs-shipped]
do_install_append() {
    rm -rf ${D}${datadir}/ament_index
}
