LICENSE = "GPL-2.0-or-later | GPL-3.0-or-later | FIPL-1.0"
LIC_FILES_CHKSUM = "file://Wrapper/Delphi/license.txt;md5=d9993e75dec47df89dbb5da6c939d046 \
                    file://license-fi.txt;md5=8e1438cab62c8f655288588dc43daaf6 \
                    file://license-gplv2.txt;md5=1fbed70be9d970d3da399f33dae9cc51"

SRC_URI = " \
    git://salsa.debian.org/science-team/freeimage.git;protocol=https;branch=debian/sid \
    file://Disable-vendored-dependencies.patch \
    file://Use-system-dependencies.patch \
    file://Fix-macro-redefinition-for-64-bit-integer-types.patch \
    file://Fix-compatibility-with-system-libpng.patch \
    file://Disable-usage-of-HTML-timestamps-in-doxygen.patch \
    file://Disable-testing-of-JPEG-transform.patch \
    file://Disable-testing-of-JXR-MemIO.patch \
    file://Fix-encoding-of-fi-header.patch \
    file://Enable-substitution-of-pkg-config.patch \
    file://CVE-2019-12211-13.patch \
    file://Fix_compilation_external-static.patch \
    file://Fix-libraw-compilation.patch \
    file://Use-system-jpeg_read_icc_profile.patch \
    file://Fix-big-endian.patch \
    file://r1830-minor-refactoring.patch \
    file://r1832-improved-BMP-plugin-when-working-with-malicious-images.patch \
    file://r1836-improved-BMP-plugin-when-working-with-malicious-images.patch \
    file://r1848-improved-PFM-plugin-against-malicious-images.patch \
    file://r1877-improved-DDS-plugin-against-malicious-images.patch \
    file://fix-include-dirs.patch \
    file://fix-freeimage-with-libraw-0.21.1.patch \
"

PV = "3.18.0-2+git${SRCPV}"
SRCREV = "10780151a1fb824a7fc9f58ca3014624605a50b3"

S = "${WORKDIR}/git"

CFLAGS += "-fPIC"
CXXFLAGS += "-fPIC"

inherit pkgconfig

DEPENDS = " \
    dos2unix-native \
    libjpeg-turbo \
    libpng \
    libraw \
    libwebp \
    jxrlib \
    openjpeg \
    openexr \
    tiff \
    zlib \
"

do_configure () {
        # From Debian rules gen-src-list target
        sh gensrclist.sh
        oe_runmake -f Makefile.gnu dos2unix
        sh genfipsrclist.sh
        oe_runmake -f Makefile.fip dos2unix
}

do_compile () {
        oe_runmake
}

do_install () {
        oe_runmake DESTDIR="${D}" install
}

FILES:${PN} = " \
  ${libdir}/libfreeimage-3.18.0.so \
"

FILES:${PN}-dev = " \
  ${libdir}/libfreeimage.so \
  ${libdir}/libfreeimage.so.3 \
  ${libdir}/libfreeimage.a \
  ${includedir}/FreeImage.h \
"

BBCLASSEXTEND = "native nativesdk"
