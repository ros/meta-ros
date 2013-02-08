DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/genpy-release/archive/release/genpy/0.4.10.tar.gz;downloadfilename=genpy_0.4.10.tar.gz"
SRC_URI[md5sum] = "694f2e0841c81a05874cf3f5801b16c1"
SRC_URI[sha256sum] = "00d585627d1f17090a99de3978dec2eef290bdadede397cf3588f7b2584ba975"

S = "${WORKDIR}/genpy-release-release-genpy-0.4.10"

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

