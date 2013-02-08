DESCRIPTION = "ROS console output library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/rosconsole/1.9.41.tar.gz;downloadfilename=rosconsole_1.9.41.tar.gz"
SRC_URI[md5sum] = "b1aa08c225ae0f81728452e08effe933"
SRC_URI[sha256sum] = "40c86e3121de8651dafed5238b8647347cf40be96066e5fa01a82875aff4a6d3"

S = "${WORKDIR}/ros_comm-release-release-rosconsole-1.9.41"

DEPENDS = "catkin-native apr boost cpp-common log4cxx rostime rosunit"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Dcpp_common_DIR=${STAGING_DATADIR}/cpp_common/cmake/ \
  -Drostime_DIR=${STAGING_DATADIR}/rostime/cmake/ \
  -Drosunit_DIR=${STAGING_DATADIR}/rosunit/cmake/ \
  "
