DESCRIPTION = "C++ implementation of Lie Groups using Eigen."
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://sophus/sophus.hpp;beginline=5;endline=21;md5=4cb78e93094b91e5b1616cb93ab7e635"

DEPENDS = "libeigen"

SRC_URI = "https://github.com/stonier/sophus/archive/${PV}.tar.gz;;downloadfilename=${PN}_${PV}.tar.gz"
SRC_URI[md5sum] = "de77d9f4b769df91bd57c5224f7f1b88"
SRC_URI[sha256sum] = "962165b5233c5d4b4d1f6c36ea77e6f3d004b9fff907f617f9952f84534177cc"

S = "${WORKDIR}/sophus-${PV}"

inherit cmake

# CXXFLAGS are needed to compile eigen 3.3.1 headers properly
CXXFLAGS += "-Wno-deprecated-declarations -Wno-misleading-indentation -Wno-int-in-bool-context -Wno-ignored-attributes"
