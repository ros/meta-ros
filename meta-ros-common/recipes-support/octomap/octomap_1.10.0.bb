DESCRIPTION = "The OctoMap library implements a 3D occupancy grid mapping approach, providing data structures and mapping algorithms in C++. The map implementation is based on an octree. See   http://octomap.github.io for details."
AUTHOR = "Armin Hornung <armin@hornung.io>"
HOMEPAGE = "http://octomap.github.io"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9b0e1f01a68f441eeaf7b5e18812d3c8"

SRC_URI = "git://github.com/OctoMap/octomap.git;protocol=https;branch=devel"

SRCREV = "863e069489ef619d7179e3b21480dffb41b2af66"

S = "${WORKDIR}/git/octomap"

inherit cmake

# Ignore
#  error: #warning "<ciso646> is deprecated in C++17, use <version> to detect implementation-specific macros" [-Werror=cpp]

EXTRA_OECMAKE += " \
    -DCMAKE_CXX_FLAGS='${CXXFLAGS} -Wno-cpp' \
"

FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

# ERROR: octomap-1.10.0-r0 do_package_qa: QA Issue: octomap:
#   /usr/bin/compare_octrees
#   /usr/bin/binvox2bt
#   /usr/bin/edit_octree
#   /usr/bin/graph2tree
#   /usr/bin/log2graph
#   /usr/bin/bt2vrml
#   /usr/bin/eval_octree_accuracy
#   /usr/bin/convert_octree
#   /usr/lib/liboctomap.so.1.10.0
#   /usr/lib/liboctomath.so.1.10.0
#   contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${bindir}/*
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
