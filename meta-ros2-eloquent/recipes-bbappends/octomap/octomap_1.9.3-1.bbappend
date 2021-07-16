# Copyright (c) 2019-2021 LG Electronics, Inc.

DEPENDS:append:class-target = " chrpath-replacement-native"

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
do_install:append() {
    chrpath --delete ${D}${bindir}/* ${D}${libdir}/*${SOLIBS}
}

inherit ros_insane_dev_so
# ERROR: octomap-1.9.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: octomap path '/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/lib/liboctomath.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: octomap path '/work/cortexa7t2hf-neon-vfpv4-oe-linux-gnueabi/octomap/1.9.2-1-r0/packages-split/octomap/usr/lib/liboctomap.so' [dev-so]

# /jenkins/mjansa/build/ose/honister/BUILD/work/qemux86-webos-linux/octomap/1.9.3-1-r0/git/src/binvox2bt.cpp: In function 'int main(int, char**)':
# /jenkins/mjansa/build/ose/honister/BUILD/work/qemux86-webos-linux/octomap/1.9.3-1-r0/git/src/binvox2bt.cpp:240:16: error: no match for 'operator>>' (operand types are 'std::ifstream' {aka 'std::basic_ifstream<char>'} and 'std::byte')
#   240 |         *input >> value;    // read the linefeed char
#       |         ~~~~~~ ^~ ~~~~~
#       |         |         |
#       |         |         std::byte
#       |         std::ifstream {aka std::basic_ifstream<char>}
CXXFLAGS += "-std=gnu++14"
