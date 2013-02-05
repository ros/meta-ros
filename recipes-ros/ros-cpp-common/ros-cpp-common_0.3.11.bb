DESCRIPTION = "Low-level build system macros and infrastructure for ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/cpp_common/0.3.11.tar.gz;downloadfilename=cpp-common_0.3.11.tar.gz"
SRC_URI[md5sum] = "7bf32963b9e2c82911bf089531c18482"
SRC_URI[sha256sum] = "86018219aa77f109d3340d332e7a041a9e047fd48d3d0e03bf2a4bd9baa66bde"

S = "${WORKDIR}/roscpp_core-release-release-cpp_common-0.3.11"

DEPENDS = "catkin-native"

EXTRA_OECMAKE = ""

inherit cmake pythonnative

FILES_${PN} += "${libdir}/*"
FILES_${PN}-dev += "${datadir}/*"

