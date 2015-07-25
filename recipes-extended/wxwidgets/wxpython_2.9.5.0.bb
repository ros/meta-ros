DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native python."
HOMEPAGE = "http://www.wxpython.org"

LICENSE = "WXwindows"
LIC_FILES_CHKSUM = "file://licence/licence.txt;md5=18346072db6eb834b6edbd2cdc4f109b"

DEPENDS = "wxwidgets"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxpython/wxPython-src-${PV}.tar.bz2"
SRC_URI[md5sum] = "a2a28fe8223391c93bf8788316767c9e"
SRC_URI[sha256sum] = "1a5b7e771eff467538d0834136188e8a7506a4fe6e85d0a46c40158cdbd4c48c"

S = "${WORKDIR}/wxPython-src-${PV}/wxPython"

inherit pkgconfig pythonnative python-dir distutils

CFLAGS += "-I${STAGING_INCDIR}/wx-2.9/ -I${STAGING_LIBDIR}/wx/include/${TARGET_PREFIX}gtk2-unicode-2.9/"
CFLAGS += "-std=gnu++11"

# Enable output on stdout for buildpaths
export WXDEBUG = "findprogress"

# remove -L/usr/X11R6/lib hardcodes
do_configure_prepend() {
	sed -i -e s:/usr/X11R6/lib::g ${S}/config.py
}

# e.g. ${D}/build/v2013.06/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/include/wx-2.9/wx/wxPython/pytree.h

do_iinstall_append() {
    cp -a ${D}${STAGING_DIR_HOST}/* ${D}
    rm -rf ${D}${STAGING_DIR}	
}
