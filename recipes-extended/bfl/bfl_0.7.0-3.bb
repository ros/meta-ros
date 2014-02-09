DESCRIPTION = "This package contains a recent version of the Bayesian Filtering Library (BFL), distributed by the Orocos Project."
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "cppunit boost"

SRC_URI = "https://github.com/ros-gbp/${PN}-release/archive/release/hydro/${PN}/${PV}.tar.gz"
SRC_URI[md5sum] = "0ef8a8dd76d7ecc78cd8f9aab80ba5a5"
SRC_URI[sha256sum] = "ecc97e979e47eefeade93c6e3905420b3e780ea434247cd2171a5f4d731352f9"

S = "${WORKDIR}/bfl-release-release-hydro-${P}"

inherit cmake

FILES_${PN}-dbg += "${bindir}/bfl/.debug"
