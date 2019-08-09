DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"

LICENSE = "WXwindows"
LIC_FILES_CHKSUM = "file://docs/licence.txt;md5=18346072db6eb834b6edbd2cdc4f109b"

DEPENDS = "webkitgtk gstreamer1.0 jpeg tiff libpng zlib expat libxinerama libglu"

SRC_URI = "https://github.com/wxWidgets/wxWidgets/releases/download/v${PV}/wxWidgets-${PV}.tar.bz2"
SRC_URI[md5sum] = "b0035731777acc5597cea8982da10317"
SRC_URI[sha256sum] = "96157f988d261b7368e5340afa1a0cad943768f35929c22841f62c25b17bf7f0"

S = "${WORKDIR}/wxWidgets-${PV}"

inherit autotools-brokensep pkgconfig binconfig

EXTRA_AUTORECONF = " -I ${S}/build/aclocal"
EXTRA_OECONF = "  --with-opengl \
                 --without-sdl \
                 --enable-mediactrl=yes \
                 --enable-webviewwebkit=yes \
                 --disable-gpe \
                 --disable-visibility \
                 --disable-rpath \
               "


CXXFLAGS := "${@oe.utils.str_filter_out('-fvisibility-inlines-hidden', '${CXXFLAGS}', d)}"
CXXFLAGS += "-std=gnu++11"

# Broken autotools :/
do_configure() {
	oe_runconf
}

# wx-config is a symlink to a file that starts with TARGET_PREFIX (and is under ${libdir}/wx/config/).
SSTATE_SCAN_FILES += "${TARGET_PREFIX}*"

SYSROOT_PREPROCESS_FUNCS += "wxwidgets_sysroot_preprocess"
wxwidgets_sysroot_preprocess () {
    sed -i -e 's,includedir="/usr/include",includedir="${STAGING_INCDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/*
    sed -i -e 's,libdir="/usr/lib",libdir="${STAGING_LIBDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/*
}

FILES_${PN} += "${bindir} ${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"
