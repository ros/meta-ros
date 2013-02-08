DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/rospack-release/archive/release/rospack/2.1.16.tar.gz;downloadfilename=rospack_2.1.16.tar.gz"
SRC_URI[md5sum] = "35b37d6bea2ed092e9265dd975b3be17"
SRC_URI[sha256sum] = "a9a997ea584ef2c41a78e03e3b24d315dc1020545b2a1a0cde474d24fe912f24"

S = "${WORKDIR}/rospack-release-release-rospack-2.1.16"

DEPENDS = "catkin-native boost python libtinyxml"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  "
