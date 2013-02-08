DESCRIPTION = "Base dependencies and support libraries for ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros-release/archive/release/roslib/1.9.42.tar.gz;downloadfilename=roslib_1.9.42.tar.gz"
SRC_URI[md5sum] = "3234ab5475e80e2598a534ab94066b40"
SRC_URI[sha256sum] = "9443166266ba025984552d764c0a74e7d4a79f9ef3b533c5de6d3220f4aa03e8"

S = "${WORKDIR}/ros-release-release-roslib-1.9.42"

DEPENDS = "catkin-native boost rospack"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
    -Drospack_DIR=${STAGING_DATADIR}/rospack/cmake/ \
  "

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

