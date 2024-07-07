DESCRIPTION = "Fully feature complete YAML parser and emitter, supporting the latest YAML spec and passing the full YAML testsuite."
HOMEPAGE = "https://github.com/pantoniou/libfyaml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6399094fbc639a289cfca2d660c010aa"

SRC_URI = "git://github.com/pantoniou/libfyaml.git;protocol=https;branch=master"
SRCREV = "8054c66e0454a09a810f756996d1b280738594e5"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
