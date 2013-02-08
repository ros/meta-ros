DESCRIPTION = "Standard ROS Messages including common message types representing primitive data types and other basic message constructs, such as multiarrays. \
    For common, generic robot-specific message types, please see common_msgs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros-gbp/std_msgs-release/archive/release/std_msgs/0.5.7.tar.gz;downloadfilename=std-msgs_0.5.7.tar.gz"
SRC_URI[md5sum] = "7665733101cc69106dd7a2902dc67f19"
SRC_URI[sha256sum] = "636f0871d52531d6764d7b26ded476a49881e5e9166999efed2f1a6ee3787fec"

S = "${WORKDIR}/std_msgs-release-release-std_msgs-0.5.7"

DEPENDS = "catkin-native message-generation"
# also depends on genlisp

FILES_${PN} += "${libdir}/*"

inherit cmake pythonnative

EXTRA_OECMAKE = " \
  -Dmessage_generation_DIR=${STAGING_DATADIR}/message_generation/cmake/ \
  "

