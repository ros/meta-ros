DESCRIPTION = "Common-Lisp ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/genlisp-release/archive/release/genlisp/0.4.10.tar.gz;downloadfilename=genlisp_0.4.10.tar.gz"
SRC_URI[md5sum] = "ce2d424a6e0496248dc2dd0c1c383f12"
SRC_URI[sha256sum] = "d9be2ac2c64f05745ca7716bfea0e3e5857554f4caf769c8550e3502d5fc257d"

S = "${WORKDIR}/genlisp-release-release-genlisp-0.4.10"

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

