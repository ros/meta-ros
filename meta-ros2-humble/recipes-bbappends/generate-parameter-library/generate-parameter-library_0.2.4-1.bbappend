FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# yocto honister specific patch
SRC_URI:append = " \
    file://0001-CMakeLists.txt-relaxing-cmake-minimum-version.patch \
"
