DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native python."
HOMEPAGE = "http://www.wxpython.org"

LICENSE = "WXwindows"
LIC_FILES_CHKSUM = "file://licence/licence.txt;md5=18346072db6eb834b6edbd2cdc4f109b"

DEPENDS = "wxwidgets"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxpython/wxPython-src-${PV}.tar.bz2"
SRC_URI[md5sum] = "922b02ff2c0202a7bf1607c98bbbbc04"
SRC_URI[sha256sum] = "d54129e5fbea4fb8091c87b2980760b72c22a386cb3b9dd2eebc928ef5e8df61"

S = "${WORKDIR}/wxPython-src-${PV}/wxPython"

inherit pkgconfig pythonnative python-dir distutils

CFLAGS += "-std=gnu++11"

# Enable output on stdout for buildpaths
export WXDEBUG = "findprogress"

DISTUTILS_BUILD_ARGS = "WX_CONFIG=${RECIPE_SYSROOT}${libdir}/wx/config/wx-config"
# Needed otherwise GTK include paths aren't added to CFLAGS.
DISTUTILS_BUILD_ARGS += "WXPORT=gtk3"

# remove -L/usr/X11R6/lib hardcodes
do_configure_prepend() {
	sed -i -e s:/usr/X11R6/lib::g ${S}/config.py
}

# e.g. ${D}/build/v2013.06/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/include/wx-2.9/wx/wxPython/pytree.h

do_iinstall_append() {
    cp -a ${D}${STAGING_DIR_HOST}/* ${D}
    rm -rf ${D}${STAGING_DIR}
}

PNBLACKLIST[wxpython] ?= "Doesn't build: 'ld: cannot find -lwx_gtk3u_xrc-3.0'"
