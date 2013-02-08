DESCRIPTION = "Integration test suite based on roslaunch that is compatible with xUnit frameworks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/rostest/1.9.41.tar.gz;downloadfilename=rostest_1.9.41.tar.gz"
SRC_URI[md5sum] = "82c09640a27dedc6b1eabed2951a23dd"
SRC_URI[sha256sum] = "f259d89e5ce02359c65dfc5bdb6c62be104600ddcb62ce6f9cffd630ff99a55d"

S = "${WORKDIR}/ros_comm-release-release-rostest-1.9.41"

DEPENDS = "catkin-native boost rosunit"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Drosunit_DIR=${STAGING_DATADIR}/rosunit/cmake/ \
  "

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

