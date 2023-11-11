DESCRIPTION = "VCS/SCM source control library for svn, git, hg, and bzr"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0ba73b6d93c2bd054ceec3f117c461c"
SRCNAME = "ros-vcstools-upstream"

SRC_URI = "https://salsa.debian.org/science-team/ros-vcstools/-/archive/upstream/${PV}/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "8ba8e7bac7f3c0c168d737c707984c67"
SRC_URI[sha256sum] = "543f452e8c8f1df709d040971669f00317e595fe979505730c2982728129056c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS:${PN} += "python3-pyyaml python3-dateutil"

inherit setuptools3

BBCLASSEXTEND = "native nativesdk"
