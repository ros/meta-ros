# Copyright (c) 2021 LG Electronics, Inc.

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

# ERROR: octomap-1.9.7-1-r0 do_package_qa: QA Issue:
# octomap: /usr/lib/liboctomath.so.1.9.7 contains probably-redundant RPATH /usr/lib
# octomap: /usr/lib/liboctomap.so.1.9.7 contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/log2graph contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/compare_octrees contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/binvox2bt contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/bt2vrml contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/convert_octree contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/graph2tree contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/edit_octree contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/eval_octree_accuracy contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${bindir}/* ${D}${libdir}/*${SOLIBS}
}
