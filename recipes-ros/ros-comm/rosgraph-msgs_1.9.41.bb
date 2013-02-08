DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/ros_comm-release/archive/release/rosgraph_msgs/1.9.41.tar.gz;downloadfilename=rosgraph-msgs_1.9.41.tar.gz"
SRC_URI[md5sum] = "741009a25766157ac436f836b5bf5519"
SRC_URI[sha256sum] = "ec8302229ad51d1174c72d12f5e849c924a8e6d5a13c42fee76f7738d15405f2"

S = "${WORKDIR}/ros_comm-release-release-rosgraph_msgs-1.9.41"

DEPENDS = "catkin-native message-generation std-msgs"

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Dmessage_generation_DIR=${STAGING_DATADIR}/message_generation/cmake/ \
  "

