DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/gencpp-release/archive/release/gencpp/0.4.11.tar.gz;downloadfilename=gencpp_0.4.11.tar.gz"
SRC_URI[md5sum] = "7a3e28fb0719805aa3a2059b6b0514fd"
SRC_URI[sha256sum] = "63258067e6c2ba034bfbcf6aaf396eb36c3c407023d7db0de1af774bbb12b6a9"

S = "${WORKDIR}/gencpp-release-release-gencpp-0.4.11"

DEPENDS = "catkin-native genmsg"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Dgenmsg_DIR=${STAGING_DATADIR}/genmsg/cmake/ \
  "

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
