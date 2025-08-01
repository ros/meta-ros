DESCRIPTION = "FCL is a library for performing three types of proximity queries on a pair of geometric models composed of triangles and octrees."
HOMEPAGE = "https://github.com/flexible-collision-library/fcl"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7de20b14c33be61ee0c714b41e286d0b"

# octomap support in fcl is needed by moveit
DEPENDS = "boost libccd libeigen octomap"

SRCREV = "df2702ca5e703dec98ebd725782ce13862e87fc8"
ROS_BRANCH ?= "branch=master"
SRC_URI = " \
    git://github.com/flexible-collision-library/fcl;${ROS_BRANCH};protocol=https \
"


EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DFCL_NO_DEFAULT_RPATH=OFF ${EXTRA_OECMAKE_SSE}"
EXTRA_OECMAKE_SSE = "-DFCL_USE_X64_SSE=OFF"
EXTRA_OECMAKE_SSE:x86-64 = ""

inherit pkgconfig cmake
