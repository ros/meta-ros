DESCRIPTION = "roscpp-serialization contains the code for serialization."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

## Problem: the filename 0.3.12.tar.gz of roscpp_traits clashes with the identical filename 0.3.12.tar.gz of rostime and rostraits
## can we somehow influence the naming?
# hack for now: downloaded the file manually and renamed it
SRC_URI = "file://roscpp-serialization_0.3.12.tar.gz"

S = "${WORKDIR}/roscpp_core-release-release-roscpp_serialization-0.3.12"

DEPENDS = "catkin-native \
  ros-cpp-common \
  roscpp-traits \
  rostime"

EXTRA_OECMAKE = \
  " -Dcpp_common_DIR=/home/lukas/poky-danny-8.0/build/tmp/sysroots/qemux86/usr/share/cpp_common/cmake/ \
    -Droscpp_traits_DIR=/home/lukas/poky-danny-8.0/build/tmp/sysroots/qemux86/usr/share/roscpp_traits/cmake/ \
    -Drostime_DIR=/home/lukas/poky-danny-8.0/build/tmp/sysroots/qemux86/usr/share/rostime/cmake/ \
  "

inherit cmake pythonnative
