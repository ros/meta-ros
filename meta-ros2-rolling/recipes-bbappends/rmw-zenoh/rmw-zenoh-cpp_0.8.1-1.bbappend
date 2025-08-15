LICENSE = "Apache-2.0 & BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Adding-inclue-algorithm-for-std-find_if.patch"

ROS_BUILD_DEPENDS += "\
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
"
