inherit ros_ament_cmake

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-CompilerSettings.cmake-remove-Werror.patch \
    file://0001-CMakeLists.txt-remove-optimizations.patch  \
"

# prevent [dev-so] qa in package
FILES:${PN}-dev += " \
    /usr/lib/liboctomap.so \
    /usr/lib/liboctomath.so \
"


