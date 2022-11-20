LICENSE = "GPLv3 & LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = "https://www.phidgets.com/downloads/phidget22/libraries/linux/libphidget22/libphidget22-${PV}.tar.gz"
SRC_URI[md5sum] = "8d8786621b225ecf6569329183774085"
SRC_URI[sha1sum] = "86fa44837e9a96e238157b3cbf32438f0e02e36c"
SRC_URI[sha256sum] = "089d590bbc9dad9cc4b190a1acab96838fdddb4afab3315679009cb622852e06"
SRC_URI[sha384sum] = "bc50e5497d148c8fa9c5e3dd3826614398e8b13eca954623c667118d1492aa35796aae35a6affd8b12aba595c6fb9615"
SRC_URI[sha512sum] = "1f8eed3bc3839cd5aebd9e231de672c669f778b2447b53ba958abd8a85251b04292b72f113b5c2befeb058d73b37628de817742276e649a5039d3d60dade8d1d"

S = "${WORKDIR}/libphidget22-${PV}"

DEPENDS = "libusb"

inherit autotools

EXTRA_OECONF = ""

