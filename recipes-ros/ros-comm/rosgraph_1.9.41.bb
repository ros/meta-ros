DESCRIPTION = "rosgraph contains the rosgraph command-line tool, which prints \
information about the ROS Computation Graph."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/rosgraph/1.9.41.tar.gz;downloadfilename=rosgraph_1.9.41.tar.gz"
SRC_URI[md5sum] = "c4a6fe2109e36f08e00634a60efa2b46"
SRC_URI[sha256sum] = "69c23ece0af24c68b404622bcbd224e84fa19da88cb08f80b62769849ba26e70"

S = "${WORKDIR}/ros_comm-release-release-rosgraph-1.9.41"

DEPENDS = "catkin-native"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  "

export BUILD_SYS
export HOST_SYS
export STAGING_LIBDIR
export STAGING_INCDIR

