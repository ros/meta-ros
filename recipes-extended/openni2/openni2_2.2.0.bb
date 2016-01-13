DESCRIPTION = "A general purpose driver for all OpenNI cameras."
HOMEPAGE = "http://structure.io/openni"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libusb1 udev"

SRC_URI = "https://github.com/occipital/OpenNI2/archive/v${PV}-debian.tar.gz"
SRC_URI[md5sum] = "bdb95be379150c6bd0433f8a6862ee7f"
SRC_URI[sha256sum] = "08f6842f20d1098ab2ebafadaac0130ffae5abd34cdf464bb6100cbe01ed95a8"

S = "${WORKDIR}/OpenNI2-${PV}-debian"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://CommonDefs.patch \
    file://openni2.pc"

do_install() {
    # Install libaries
    install -m 0755 -d ${D}${libdir}/
    install -m 0644 -t ${D}${libdir}/ ${S}/Bin/ARM-Release/libOpenNI2.so
    install -m 0755 -d ${D}${libdir}/OpenNI2/Drivers/
    install -m 0644 -t ${D}${libdir}/OpenNI2/Drivers/ ${S}/Bin/ARM-Release/OpenNI2/Drivers/*.so

    # Install header files
    install -m 0755 -d ${D}${includedir}/openni2/
    install -m 0644 -t ${D}${includedir}/openni2/ ${S}/Include/*.h
    install -m 0755 -d ${D}${includedir}/openni2/Driver/
    install -m 0644 -t ${D}${includedir}/openni2/Driver/ ${S}/Include/Driver/*.h
    install -m 0755 -d ${D}${includedir}/openni2/Linux-Arm/
    install -m 0644 -t ${D}${includedir}/openni2/Linux-Arm/ ${S}/Include/Linux-Arm/*.h
    install -m 0755 -d ${D}${includedir}/openni2/Linux-x86/
    install -m 0644 -t ${D}${includedir}/openni2/Linux-x86/ ${S}/Include/Linux-x86/*.h

    # Install configuration files
    install -m 0755 -d ${D}${libdir}/pkgconfig/
    install -m 0644 -t ${D}${libdir}/pkgconfig/ ${WORKDIR}/openni2.pc

    install -m 0755 -d ${D}${sysconfdir}/openni2/
    install -m 0644 -t ${D}${sysconfdir}/openni2/ ${S}/Config/OpenNI.ini

    install -b 0755 -d ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 -T ${S}/Packaging/Linux/primesense-usb.rules ${D}${sysconfdir}/udev/rules.d/40-openni2.rules
}

FILES_${PN} += "${libdir}/libOpenNI2.so ${libdir}/OpenNI2/Drivers"
FILES_${PN}-dbg += "${libdir}/OpenNI2/Drivers/.debug"

# Need to override this, otherwise libOpenNI2.so is included in dev package
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

inherit pkgconfig
