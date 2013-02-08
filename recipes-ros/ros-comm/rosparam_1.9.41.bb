DESCRIPTION = "the rosparam command-line tool for getting and setting \ 
  ROS Parameters on the Parameter Server using YAML-encoded files."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/rosparam/1.9.41.tar.gz;downloadfilename=rosparam_1.9.41.tar.gz"
SRC_URI[md5sum] = "9539b0fbb6e50d44a6038d2f4d57d67b"
SRC_URI[sha256sum] = "49a6e4c5d8607bebf3b995fe2b4f2105898ebbac04e542008e953baa0892b255"

S = "${WORKDIR}/ros_comm-release-release-rosparam-1.9.41"

DEPENDS = "catkin-native"

FILES_${PN} += "${libdir}/*"

inherit distutils cmake pythonnative

EXTRA_OECMAKE = " \
  "

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

