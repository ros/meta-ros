DESCRIPTION = "FCL is a library for performing three types of proximity queries on a pair of geometric models composed of triangles and octrees."
HOMEPAGE = "https://github.com/flexible-collision-library/fcl"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5823baab4b8de52197d0fb775e8fd4b7"

# Octomap dependency not included as it is optional.
DEPENDS = "boost libccd"

SRCREV = "49a6edfa058773b428cdf69831f4d3ea6ea69cb0"
ROS_BRANCH ?= "branch=master"
SRC_URI = " \
    git://github.com/flexible-collision-library/fcl;${ROS_BRANCH};protocol=https \
    file://0001-Add-configure-option-NO_DEFAULT_RPATH.patch \
    file://LICENSE;subdir=git \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DNO_DEFAULT_RPATH=OFF"
FILES_${PN} += "${libdir}/libfcl.so"

# Need to override this, otherwise libfcl.so is included in dev packageW.
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

inherit pkgconfig cmake
