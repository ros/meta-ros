FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-CMakeLists.txt-remove-Werror-from-compile-flags.patch \
"

DEPENDS:append = " \
   ament-package-native \
   ament-cmake-libraries-native \
   ament-cmake-native \
"
