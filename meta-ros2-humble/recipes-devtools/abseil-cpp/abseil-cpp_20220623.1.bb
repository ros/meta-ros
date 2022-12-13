SUMMARY = "Abseil is a cpp library like STL"
DESCRIPTION = "Abseil provides pieces missing from the C++ standard. Contains \
additional useful libraries like algorithm, container, debugging, hash, memory, \
meta, numeric, strings, synchronization, time, types and utility"
HOMEPAGE = "https://abseil.io/"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=df52c6edb7adc22e533b2bacc3bd3915"

PV = "20220623.1+git${SRCPV}"
SRCREV = "8c0b94e793a66495e0b1f34a5eb26bd7dc672db0"
BRANCH = "lts_2022_06_23"
SRC_URI = "git://github.com/abseil/abseil-cpp;branch=${BRANCH};protocol=https \
           file://0001-absl-always-use-asm-sgidefs.h.patch             \
           file://0002-Remove-maes-option-from-cross-compilation.patch \
           file://abseil-ppc-fixes.patch \
           file://0003-Remove-neon-option-from-cross-compilation.patch \
          "

S = "${WORKDIR}/git"

DEPENDS_append_libc-musl = " libexecinfo "

ASNEEDED_class-native = ""
ASNEEDED_class-nativesdk = ""

inherit cmake

BBCLASSEXTEND = "native nativesdk"
ALLOW_EMPTY_${PN} = "1"
