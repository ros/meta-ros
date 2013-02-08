DESCRIPTION = "roswtf is a tool for diagnosing issues with a running ROS system. Think of it as a FAQ implemented in code."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/roswtf/1.9.41.tar.gz;downloadfilename=roswtf_1.9.41.tar.gz"
SRC_URI[md5sum] = "422724ca5fb8bb1424f1cd7f73c9f7aa"
SRC_URI[sha256sum] = "74f8028c7eb43e2507d70461257c48cca3c4ea162eaf66e0163d307846d32ce3"

S = "${WORKDIR}/ros_comm-release-release-roswtf-1.9.41"

DEPENDS = "catkin-native rostest"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Drostest_DIR=${STAGING_DATADIR}/rostest/cmake/ \
  "
