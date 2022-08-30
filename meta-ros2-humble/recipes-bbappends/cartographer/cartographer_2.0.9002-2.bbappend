ROS_BUILDTOOL_DEPENDS:append = " \
    protobuf-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-CMakeLists.txt-Setting-CXX-std-to-C-14.patch \
"
