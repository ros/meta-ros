DESCRIPTION = "roscpp-traits contains the message traits code."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/roscpp_traits/0.3.12.tar.gz;downloadfilename=roscpp-traits_0.3.12.tar.gz"
SRC_URI[md5sum] = "bf9d1ef41bb21a8ee1b2defa415cc0d8"
SRC_URI[sha256sum] = "f35cd1e29b50a2ffd89b36a9c919653ba2f6242c4b92618b544ded4f005ab912"

S = "${WORKDIR}/roscpp_core-release-release-roscpp_traits-0.3.12"

ALLOW_EMPTY = "1"

DEPENDS = "catkin-native"

inherit cmake pythonnative
