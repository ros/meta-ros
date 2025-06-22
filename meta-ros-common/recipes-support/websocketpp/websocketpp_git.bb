SUMMARY = "C++/Boost Asio based websocket client/server library."
SECTION = "libs/network"
HOMEPAGE = "https://github.com/zaphoyd/websocketpp"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=caca8c57fc82d4528bfd694b3de9b7cf"

DEPENDS = " ${@bb.utils.contains('DISTRO_FEATURES', 'ptest', 'openssl boost zlib', '', d)} "

SRC_URI = "git://github.com/zaphoyd/websocketpp.git;protocol=https;branch=develop \
           file://0001-fixed-incompatibility-with-Boost-1.87-due-to-use-of-.patch \
           file://0002-updated-docstrings.patch \
           file://0003-updated-docstrings.patch \
           file://0004-silenced-warning-about-unused-variable-in-TLS-IP-add.patch \
           file://0005-improved-variable-names-and-fixed-comments.patch \
           file://0006-fixed-use-of-deprecated-boost-asio-deadline_timer-in.patch \
           file://0007-replaced-uses-of-boost-asio-io_context-strand-wrap-w.patch \
          "

EXTRA_OECMAKE = "${@bb.utils.contains('DISTRO_FEATURES', 'ptest', '-DBUILD_EXAMPLES=ON -DBUILD_TESTS=ON', '', d)} "

# this is an header only library, do not depend on the main package
RDEPENDS:${PN}-dev = ""

# to add this package to an SDK, since it isn't a reverse-dependency of anything, just use something like this:
# TOOLCHAIN_TARGET_TASK:append = " websocketpp-dev"

# branch develop
SRCREV = "b9aeec6eaf3d5610503439b4fae3581d9aff08e8"


inherit cmake

PACKAGES =+ "${PN}-examples"

FILES:${PN}-examples = "${docdir}"

do_install:append() {
	install -d ${D}${docdir}/${BPN}
	cp -R ${S}/examples ${D}${docdir}/${BPN}
}
