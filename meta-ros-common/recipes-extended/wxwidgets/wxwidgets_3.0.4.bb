DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"

LICENSE = "WXwindows"
LIC_FILES_CHKSUM = "file://docs/licence.txt;md5=18346072db6eb834b6edbd2cdc4f109b"

# XXX Set up PACKAGECONFIG
DEPENDS = "gtk+3 jpeg tiff libpng zlib expat libglu"
#DEPENDS = "webkitgtk gstreamer1.0 jpeg tiff libpng zlib expat libxinerama libglu"

SRC_URI = "https://github.com/wxWidgets/wxWidgets/releases/download/v${PV}/wxWidgets-${PV}.tar.bz2"
SRC_URI[md5sum] = "b0035731777acc5597cea8982da10317"
SRC_URI[sha256sum] = "96157f988d261b7368e5340afa1a0cad943768f35929c22841f62c25b17bf7f0"

S = "${WORKDIR}/wxWidgets-${PV}"

inherit autotools-brokensep pkgconfig binconfig

EXTRA_AUTORECONF = " -I ${S}/build/aclocal"
EXTRA_OECONF = "  --with-opengl \
                 --without-sdl \
                 --enable-mediactrl=no \
                 --enable-webviewwebkit=no \
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

# Users of wxwidgets will want to execute what the symlink wx-config points to, but it's installed under ${bindir}, which
# isn't included in the sysroot (because it contains wxrc, a cross-compiled executable). So instead, place it under
# ${libdir}/wx/config and require that users of wxwidgets cause it to be invoked by adding passing
# "WX_CONFIG=${RECIPE_SYSROOT}${libdir}/wx/config/wx-config" when configuring.
do_install_append() {
    rm -f ${D}${bindir}/wx-config
    # There's only one file under ${libdir}/wx/config/, and its name starts with ${TARGET_PREFIX}
    if [ -d ${D}${libdir}/wx/config/ ]; then
        cd ${D}${libdir}/wx/config/
        ln -snf ${TARGET_PREFIX}* wx-config
        cd - > /dev/null
    else
        true
    fi
}

# wx-config is a symlink to a file that starts with TARGET_PREFIX (and is under ${libdir}/wx/config/).
SSTATE_SCAN_FILES += "${TARGET_PREFIX}*"

SYSROOT_PREPROCESS_FUNCS += "wxwidgets_sysroot_preprocess"
wxwidgets_sysroot_preprocess () {
    sed -i -e 's,includedir="/usr/include",includedir="${STAGING_INCDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/${TARGET_PREFIX}*
    sed -i -e 's,libdir="/usr/lib",libdir="${STAGING_LIBDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/${TARGET_PREFIX}*
    sed -i -e 's,bindir="/usr/bin",bindir="${STAGING_BINDIR}",g' ${SYSROOT_DESTDIR}${libdir}/wx/config/${TARGET_PREFIX}*
}

FILES_${PN} += "${bindir} ${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"

inherit features_check
# Depends on freeglut with this restriction:
REQUIRED_DISTRO_FEATURES = "opengl"
# and libglu with this:
REQUIRED_DISTRO_FEATURES += "x11"
