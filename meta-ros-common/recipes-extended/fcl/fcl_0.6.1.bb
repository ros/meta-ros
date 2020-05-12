DESCRIPTION = "FCL is a library for performing three types of proximity queries on a pair of geometric models composed of triangles and octrees."
HOMEPAGE = "https://github.com/flexible-collision-library/fcl"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7de20b14c33be61ee0c714b41e286d0b"

# Octomap dependency not included as it is optional.
DEPENDS = "boost libccd libeigen"

SRCREV = "97455a46de121fb7c0f749e21a58b1b54cd2c6be"
ROS_BRANCH ?= "branch=master"
SRC_URI = " \
    git://github.com/flexible-collision-library/fcl;${ROS_BRANCH};protocol=https \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DFCL_NO_DEFAULT_RPATH=OFF"

inherit pkgconfig cmake
