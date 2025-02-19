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

# ERROR: octomap-1.10.0-r0 do_package_qa: QA Issue: octomap: /usr/bin/compare_octrees contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/binvox2bt contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/edit_octree contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/graph2tree contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/log2graph contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/bt2vrml contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/eval_octree_accuracy contains probably-redundant RPATH /usr/lib
# octomap: /usr/bin/convert_octree contains probably-redundant RPATH /usr/lib
# octomap: /usr/lib/liboctomap.so.1.10.0 contains probably-redundant RPATH /usr/lib
# octomap: /usr/lib/liboctomath.so.1.10.0 contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"
do_install:append() {
    chrpath --delete ${D}${bindir}/* ${D}${libdir}/*${SOLIBS}
}

FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"
