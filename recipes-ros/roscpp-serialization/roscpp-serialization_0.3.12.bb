DESCRIPTION = "roscpp-serialization contains the code for serialization."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/roscpp_core-release/archive/release/roscpp_serialization/0.3.12.tar.gz;downloadfilename=roscpp-serialization_0.3.12.tar.gz"
SRC_URI[md5sum] = "38827d61eb88211d6be597d3be30ee58"
SRC_URI[sha256sum] = "27581440aabb75df787e850124daaec252fdca8f5b70f8a4996f82bb8eb65eb7"

S = "${WORKDIR}/roscpp_core-release-release-roscpp_serialization-0.3.12"

DEPENDS = "catkin-native \
  ros-cpp-common \
  roscpp-traits \
  rostime"

EXTRA_OECMAKE = " \
    -Dcpp_common_DIR=${STAGING_DATADIR}/cpp_common/cmake/ \
    -Droscpp_traits_DIR=${STAGING_DATADIR}/roscpp_traits/cmake/ \
    -Drostime_DIR=${STAGING_DATADIR}/rostime/cmake/ \
  "

inherit cmake pythonnative
