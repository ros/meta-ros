LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f4aeab062d8bdd17461f50cf4d1ca0fd"

SRC_URI = " \
  git://github.com/RPS98/pid_controller.git;protocol=https;branch=main \
  file://gtest_find_package.patch \
"

PV = "1.0+git${SRCPV}"
SRCREV = "30020f18e9931e4ada66c6ed41e175eae1d4266b"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "google-benchmark libeigen googletest"

do_install() {
    install -d -m 0755 ${D}/${libdir}
    install -D -m 0644 ${B}/libpid_controller.so ${D}/${libdir}

    install -d -m 0755 ${D}/${includedir}/pid_controller
    install -D -m 0644 ${S}/include/pid_controller/*.hpp ${D}/${includedir}/pid_controller
}

FILES:${PN} = " ${libdir}/libpid_controller.so"
FILES:${PN}-dev = "${includedir}/pid_controller/pid_1d.hpp  ${includedir}/pid_controller/pid.hpp"
