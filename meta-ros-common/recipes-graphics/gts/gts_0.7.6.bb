LICENSE = "LGPL-2.0-only & Unknown"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7 \
                    file://debian/copyright;md5=98f2cb72cc54864f096332707c784f81"

SRC_URI = "git://anonscm.debian.org/git/debian-science/packages/gts.git;protocol=https;branch=master \
           file://fix-includes.patch \
           file://fix-predicates_init.patch \
"

PV = "0.7.6+git${SRCPV}"
SRCREV = "7cfcef0d9fc44f4fe424455027e78b73864590ec"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0"

inherit autotools pkgconfig

BBCLASSEXTEND = "native nativesdk"
