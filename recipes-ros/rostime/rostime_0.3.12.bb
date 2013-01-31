DESCRIPTION = "Time and Duration implementations for C++ libraries, including roscpp."
SECTION = "devel"
# TODO: License of cpp_common not mentioned in the file
LICENSE = "CLOSED"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/rostime/0.3.12.tar.gz"
SRC_URI[md5sum] = "ad80d12cf7dac87e7a5ef4573ced9db7"
SRC_URI[sha256sum] = "887a89406d9682dc49c4049b4fe0766b6613208fd9df95a0efa55579b93cc965"

S = "${WORKDIR}/roscpp_core-release-release-rostime-0.3.12"

DEPENDS = "catkin-native boost ros-cpp-common"
RDEPENDS = "boost ros-cpp-common"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = "-DCMAKE_PREFIX_PATH=/home/lukas/poky-danny-8.0/build/tmp/sysroots/qemux86/usr/share/cpp_common/cmake/ \
  -Dcpp_common_DIR=/home/lukas/poky-danny-8.0/build/tmp/sysroots/qemux86/usr/share/cpp_common/cmake/"
