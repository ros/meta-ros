FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-CMakeLists.txt-removing-idiot-Werror.patch \
"

DEPENDS:append = " \
    ament-cmake-core-native \
    ament-package-native  \
    ament-cmake-libraries-native \
    ament-cmake-native \
    python3-numpy-native \
"
