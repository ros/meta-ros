LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/astrand/xclip;protocol=https;branch=master"

SRCREV = "2c3b811002b35d3be7f39cc1145dd06bdb32e31c"

DEPENDS = "libxmu libx11"

inherit autotools-brokensep
