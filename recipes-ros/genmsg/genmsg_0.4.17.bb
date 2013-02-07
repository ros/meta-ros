DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/genmsg-release/archive/release/genmsg/0.4.17.tar.gz;downloadfilename=genmsg_0.4.17.tar.gz"
SRC_URI[md5sum] = "cd88647b1f37987e75a543ff826dbfcb"
SRC_URI[sha256sum] = "12509645b02dbe8180321fc263abb45feded4cc1172eb485a2780ed93607e64e"

S = "${WORKDIR}/genmsg-release-release-genmsg-0.4.17"

DEPENDS = "catkin-native"

FILES_${PN} += "${libdir}/*"

inherit distutils cmake pythonnative

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

