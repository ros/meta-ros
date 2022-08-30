ROS_BUILD_DEPENDS:append = " \
    libsdl2 \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " \
     file://0001-CMakeLists.txt-using-pkgconfig-instead-of-FindSDL2.patch \
"

inherit pkgconfig
