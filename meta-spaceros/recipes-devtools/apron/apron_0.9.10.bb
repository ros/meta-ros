LICENSE = "GPL-2.0-only & LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f56c8623c809daef0ffab105bc94dc3b \
                    file://apron/COPYING;md5=598db4a507695ea6fedf9f0e0561ea44 \
                    file://apronxx/COPYING.GPL;md5=eb723b61539feef013de476e68b5c50a \
                    file://apronxx/COPYING.LGPL;md5=fbc093901857fcd118f065f900982c24 \
                    file://box/COPYING;md5=f90109c6a36794f7103e2cdc7ba4610e \
                    file://itv/COPYING;md5=960e52fb8d4e78e01099353fef34dc93 \
                    file://mlapronidl/COPYING;md5=d9c7fbd7a09c738e589a4b98d2373de5 \
                    file://newpolka/COPYING;md5=eefd046f3b10458aa2294cd37d072c14 \
                    file://octagons/COPYING;md5=3c757ff1842afe06642612cdae4525e1 \
                    file://ppl/COPYING;md5=72eb09109d59e40a531bc41603bd2d24 \
                    file://products/COPYING;md5=25297c12a66fb260edef17738d835b65 \
                    file://test/COPYING;md5=ffca3db1adf5f1276cc5a47ded63ff95"

SRC_URI = "http://deb.debian.org/debian/pool/main/a/apron/apron_0.9.10.orig.tar.gz \
           file://fix-invalid-operants-to-binary-expression-patch \
           file://fix-link-error.patch \
           file://fix-missing-mpfr.patch \
           file://fix-static-decl-strdup.patch \
           file://fix-makefile-config.patch \
           file://minor-fixes.patch \
           file://fix-octagons-makefile.patch \
           file://use-cc.patch \
           file://fix-for-new-cpp-warning.patch \
           file://fix-apron-installdir.patch \
           file://fix-ppl-makefile.patch \
           file://add-ldflags.patch \
           "
SRC_URI[sha256sum] = "f3fb6efff04948fa8277b16b9ae371c0fe5ea1460f4056117b32f813bf1a0b94"

S = "${WORKDIR}/${BPN}-dist-${PV}/apron"

# box_representation.c: In function 'box_fprintdiff':
# box_representation.c:273:11: error: format not a string literal and no format arguments [-Werror=format-security]
CFLAGS += "-Wno-error=format-security"

DEPENDS = "gmp mpfr ppl"

do_configure () {
        cp ${S}/Makefile.config.model ${S}/Makefile.config
        sed -i -e "s,^# APRON_PREFIX = /usr,APRON_PREFIX = ${D}${prefix}," ${S}/Makefile.config
        sed -i -e "s,^# GMP_PREFIX = /usr,GMP_PREFIX = ${RECIPE_SYSROOT}${prefix}," ${S}/Makefile.config
        sed -i -e "s,^# PPL_PREFIX = /usr,PPL_PREFIX = ${RECIPE_SYSROOT}${prefix}," ${S}/Makefile.config
        sed -i -e "s,^# MPFR_PREFIX = /usr,MPFR_PREFIX = ${RECIPE_SYSROOT}${prefix}," ${S}/Makefile.config
        sed -i -e "s,\$(PREFIX)/lib,\$(PREFIX)/${baselib},g" ${S}/*/Makefile
}

do_compile () {
	oe_runmake -C ${S}/itv
	oe_runmake -C ${S}/apron
	oe_runmake -C ${S}/newpolka
	oe_runmake -C ${S}/ppl
	oe_runmake -C ${S}/num
	oe_runmake -C ${S}/box
	oe_runmake -C ${S}/octagons
	oe_runmake -C ${S}/products
}

do_install () {
	oe_runmake -C ${S}/itv install
	oe_runmake -C ${S}/apron install
	oe_runmake -C ${S}/newpolka install
	oe_runmake -C ${S}/ppl install
	oe_runmake -C ${S}/num install
	oe_runmake -C ${S}/box install
	oe_runmake -C ${S}/octagons install
	oe_runmake -C ${S}/products install
        rmdir ${D}${bindir}
}

FILES:${PN} = "${libdir}/*.mli ${libdir}/*.idl ${libdir}/*.ml ${libdir}/*.so"
FILES:${PN}-dev = "${includedir}"
