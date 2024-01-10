LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f4aeab062d8bdd17461f50cf4d1ca0fd"

SRC_URI = " \
  git://github.com/RPS98/pid_controller.git;protocol=https;branch=main \
"

PV = "0.1+git${SRCPV}"
SRCREV = "2dde9bb696115242dda4e4d237fd58acc5cfa770"

S = "${WORKDIR}/git"

inherit cmake python3native

DEPENDS = " \
    google-benchmark \
    libeigen \
    ament-cmake \
    ament-cmake-clang-format \
    ament-cmake-cppcheck \
    ament-cmake-libraries \
    ament-cmake-export-definitions \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-gen-version-h \
    ament-cmake-libraries \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-include-directories \
    ament-cmake-test \
    ament-cmake-version \
    ament-clang-format-native \
    ament-cppcheck-native \
    ament-package-native \
    python3-catkin-pkg-native \
"

do_install() {
    install -d -m 0755 ${D}/${libdir}
    install -D -m 0644 ${B}/libpid_controller.a ${D}/${libdir}

    install -d -m 0755 ${D}/${includedir}/pid_controller
    install -D -m 0644 ${S}/include/pid_controller/*.hpp ${D}/${includedir}/pid_controller
}

FILES:${PN} = " ${libdir}/libpid_controller.a"
FILES:${PN}-dev = "${includedir}/pid_controller/PID_3D.hpp  ${includedir}/pid_controller/PID.hpp"
