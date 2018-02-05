DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"

LICENSE = "WXwindows"
LIC_FILES_CHKSUM = "file://docs/licence.txt;md5=18346072db6eb834b6edbd2cdc4f109b"

DEPENDS = "webkit-gtk gstreamer gtk+ jpeg tiff libpng zlib expat libxinerama libglu"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxWidgets-${PV}.tar.bz2"
SRC_URI[md5sum] = "e98c5f92805493f150656403ffef3bb0"
SRC_URI[sha256sum] = "b74ba96ca537cc5d049d21ec9ab5eb2670406a4aa9f1ea4845ea84a9955a6e02"

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

# wx-config contains entries like this:
# this_prefix=`check_dirname "/build/v2013.06/build/tmp-angstrom_v2013_06-eglibc/work/cortexa8hf-vfp-neon-angstrom-linux-gnueabi/wxwidgets/2.9.5-r0/wxWidgets-2.9.5"`
do_install_prepend() {
	sed -i -e s:${S}:${STAGING_DIR_HOST}${prefix}:g ${S}/wx-config
}

# wx-config doesn't handle the suffixed libwx_media, xrc, etc, make a compat symlink
do_install_append() {
	for lib in adv aui core html media propgrid qa ribbon richtext stc webview xrc ; do
		ln -sf libwx_gtk2u_$lib-2.9.so.5.0.0 ${D}${libdir}/libwx_gtk2u_$lib-2.9.so
	done
}

SYSROOT_PREPROCESS_FUNCS += "wxwidgets_sysroot_preprocess"
wxwidgets_sysroot_preprocess () {
    sed -i -e 's,includedir="/usr/include",includedir="${STAGING_INCDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/*
    sed -i -e 's,libdir="/usr/lib",libdir="${STAGING_LIBDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/*
}

FILES_${PN} += "${bindir} ${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"
