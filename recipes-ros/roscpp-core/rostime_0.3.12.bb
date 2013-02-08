DESCRIPTION = "Time and Duration implementations for C++ libraries, including roscpp."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/rostime/0.3.12.tar.gz;downloadfilename=rostime_0.3.12.tar.gz"
SRC_URI[md5sum] = "ad80d12cf7dac87e7a5ef4573ced9db7"
SRC_URI[sha256sum] = "887a89406d9682dc49c4049b4fe0766b6613208fd9df95a0efa55579b93cc965"

S = "${WORKDIR}/roscpp_core-release-release-rostime-0.3.12"

DEPENDS = "catkin-native boost ros-cpp-common"
RDEPENDS = "boost ros-cpp-common"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Dcpp_common_DIR=${STAGING_DATADIR}/cpp_common/cmake/ \
  "
