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

FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"
