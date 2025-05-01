FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-remove-missing-braces-error-compile-option.patch"

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

CXXFLAGS += "-Wno-deprecated-declarations"
