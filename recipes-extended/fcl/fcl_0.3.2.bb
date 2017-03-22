DESCRIPTION = "FCL is a library for performing three types of proximity queries on a pair of geometric models composed of triangles and octrees."
HOMEPAGE = "https://github.com/flexible-collision-library/fcl"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5823baab4b8de52197d0fb775e8fd4b7"

# Octomap dependency not included as it is optional.
DEPENDS = "boost libccd"

SRC_URI = "https://github.com/flexible-collision-library/fcl/archive/${PV}.tar.gz \
           file://0001-Add-configure-option-NO_DEFAULT_RPATH.patch \
          "
SRC_URI[md5sum] = "b12246df3f4e1d0768ce1e46a52900ff"
SRC_URI[sha256sum] = "cf914f85b32cf8b63879907726df64e50da33f00d538759d789fe10fc5fbc95b"

S = "${WORKDIR}/fcl-${PV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://LICENSE;subdir=fcl-${PV}"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DNO_DEFAULT_RPATH=OFF"
FILES_${PN} += "${libdir}/libfcl.so"

# Need to override this, otherwise libfcl.so is included in dev packageW.
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

inherit pkgconfig cmake
