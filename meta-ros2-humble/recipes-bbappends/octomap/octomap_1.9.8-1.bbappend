inherit ros_ament_cmake

# prevent [dev-so] qa in package
FILES:${PN}-dev += " \
    /usr/lib/liboctomap.so \
    /usr/lib/liboctomath.so \
"

# Copyright (c) 2021 LG Electronics, Inc.

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

