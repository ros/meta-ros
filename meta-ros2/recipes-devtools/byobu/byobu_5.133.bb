# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

SUMMARY = "Open source text-based window manager and terminal multiplexer."
HOMEPAGE = "https://github.com/dustinkirkland/byobu"
SECTION = "console/utils"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

DEPENDS = "tmux"
RDEPENDS_${PN} += "bash perl"

SRC_URI = "git://github.com/dustinkirkland/byobu;branch=master;protocol=https"
SRCREV = "5b0f996c7da750136d45fa6db3ba06c6a0ecf0cc"
S = "${WORKDIR}/git"

FILES_${PN} +=  "/usr/share/dbus-1 \
		/usr/share/dbus-1/services \
		/usr/share/dbus-1/services/us.kirkland.terminals.byobu.service \
		"

inherit autotools pkgconfig
