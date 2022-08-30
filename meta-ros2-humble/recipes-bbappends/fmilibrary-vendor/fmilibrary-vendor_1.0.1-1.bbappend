ROS_BUILD_DEPENDS:append = " \
    fmilibrary \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-CMakeLists.txt-removing-build-of-fmilibrary.patch \
"
