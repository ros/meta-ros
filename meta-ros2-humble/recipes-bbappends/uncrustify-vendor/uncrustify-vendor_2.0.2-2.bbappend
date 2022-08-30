FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-CMakeLists.txt-changed-version-matching-schema.patch \
"

ROS_BUILDTOOL_DEPENDS += " \
    uncrustify-native \
"