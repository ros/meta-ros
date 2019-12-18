# Copyright (c) 2019 LG Electronics, Inc.

DEPENDS_append_class-target = " chrpath-replacement-native"

# WARNING: octomap-1.9.2-1-r0 do_package_qa: QA Issue: octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/log2graph contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/binvox2bt contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/bt2vrml contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/eval_octree_accuracy contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/graph2tree contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/edit_octree contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/compare_octrees contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/bin/convert_octree contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/lib/liboctomath.so.1.9.2 contains probably-redundant RPATH /usr/lib
# octomap: /work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/lib/liboctomap.so.1.9.2 contains probably-redundant RPATH /usr/lib [useless-rpaths]
do_install_append() {
    chrpath --delete ${D}${bindir}/* ${D}${libdir}/*${SOLIBS}
}

inherit ros-insane
# ERROR: octomap-1.9.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: octomap path '/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/lib/liboctomath.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: octomap path '/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/lib/liboctomap.so' [dev-so]
