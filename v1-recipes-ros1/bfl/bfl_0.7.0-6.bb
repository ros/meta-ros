DESCRIPTION = "This package contains a recent version of the Bayesian Filtering Library (BFL), distributed by the Orocos Project."
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "cppunit boost"

SRC_URI = "https://github.com/ros-gbp/${PN}-release/archive/release/indigo/${PN}/${PV}.tar.gz"
SRC_URI[md5sum] = "8140555e28ddea22a10a9ec59d96a4a0"
SRC_URI[sha256sum] = "296bec7f11430dd99a9617333d91c5c94ccf96ef6a4aa242917cc19480169740"

SRC_URI += "file://0001-drop-pathes-to-unused-libraries-for-passing-the-qa_s.patch"

S = "${WORKDIR}/bfl-release-release-indigo-${P}"

inherit cmake faulty-solibs

PACKAGES += "${PN}-tests"

FILES_${PN}-dbg += "${bindir}/bfl/.debug"
FILES_${PN}-tests = "${bindir}/bfl/*"
