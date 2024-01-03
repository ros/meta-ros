LICENSE = "GPL-3.0-only & LGPL-2.1-only & LGPL-3.0-only & Unknown"
LIC_FILES_CHKSUM = "file://GPL.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://LGPL.txt;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                    file://Platform/Android/jni/External/libusb-1.0.8/COPYING;md5=fbc093901857fcd118f065f900982c24 \
                    file://Platform/Win32/Build/Utils/niLicense/niLicense.vcxproj;md5=e3e584976adbdbe7fe36969fa280077f \
                    file://Platform/Win32/Build/Utils/niLicense/niLicense.vcxproj.filters;md5=30049d9d4da6543fa72318366064ffd7 \
                    file://Source/DoxyGen/Text/Concepts.Licenses.txt;md5=3bc7746add86e5a008f7e123b6999a5b \
                    file://Source/DoxyGen/Text/Legal.txt;md5=61efb11ab261292cea446afb9f0d271d \
                    file://Source/Utils/niLicense/niLicense.cpp;md5=3e4a2ddd36631d4b680a90ecc8aea2c9 \
                    file://Wrappers/OpenNI.java/src/org/OpenNI/License.java;md5=1f22be124db84ec8d90098bc656ff8e3 \
                    file://debian/copyright;md5=1a13640fd1d84f012020cd971f8e0c98 \
                    file://debian/niLicense.1;md5=2c8976ac64075388e0afac5b5987a232"

SRC_URI = "git://salsa.debian.org/multimedia-team/openni.git;protocol=https;branch=master \
  file://0001-do-not-build-mono-samples.patch \
  file://0002-Add-SONAME-to-libraries.patch \
  file://0003-Change-path-of-config-files-to-etc-openni.patch \
  file://0004-Disable-SSE.patch \
  file://0005-Silence-asserts.patch \
  file://0006-Use-system-wide-libjpeg.patch \
  file://0007-Use-system-wide-tinyxml.patch \
  file://0008-Fix-preprocessor-macro-to-be-C-11-compatible.patch \
  file://0009-Remove-superfluous-printf.patch \
  file://0011-do-not-compile-windows-chm-file.patch \
  file://0012-Remove-j-from-make-flags-fixes-bug-on-arm.patch \
  file://0013-Enabled-ppc.patch \
  file://0013-Add-ARM-support.patch \
  file://0014-Add-arm64-support.patch \
  file://0015-Add-mipsel-support.patch \
  file://0016-Rename-equivalent-to-fix-compilation-on-gcc6.patch \
  file://0017-Remove-wrong-compiler-flags-for-arm.patch \
  file://0018-Disable-mono-build.patch \
  file://0019-Port-to-Python-3.patch \
  file://0020-Switch-to-__i386__-as-i386-is-not-defined-in-std-c-1.patch \
  file://0021-Support-riscv64.patch \
  file://0022-Add-loongarch64-support.patch \
  file://configure-only.patch \
  file://do-not-build-java-samples.patch \
  file://fix-system-wide-check.patch \
"

PV = "1.5.4.0+git${SRCPV}"
SRCREV = "4701cc457627ecf9441db1cde24e0939103b8052"

S = "${WORKDIR}/git"
B = "${S}"

inherit python3native

DEPENDS += " \
    doxygen-native \
    graphviz \
    libjpeg-turbo \
    libtinyxml \
    libusb \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl libglu', '', d)} \
    freeglut \
"

do_configure () {
	cd ${S}/Platform/Linux/CreateRedist && ./RedistMaker
}

do_compile () {
	# Build Project
        # Build
	oe_runmake -C ${S}/Platform/Linux/Build clean
	oe_runmake -C ${S}/Platform/Linux/Build

	# Doxygen
        cd ${B}/Source/DoxyGen
        rm -rf ${B}/Source/DoxyGen/html
        # Running doygen
	mkdir ${B}/Source/DoxyGen/html
	doxygen Doxyfile > ${B}/Platform/Linux/CreateRedist/Output/EngineDoxy.txt
        # remove uneeded files
        rm -f ${B}/Source/DoxyGen/html/*.map
        rm -f ${B}/Source/DoxyGen/html/*.md5
        rm -f ${B}/Source/DoxyGen/html/*.hhc
        rm -f ${B}/Source/DoxyGen/html/*.hhk
        rm -f ${B}/Source/DoxyGen/html/*.hhp
}

do_install () {
	# Create Redist Dir
        # Creating new directory tree
	#install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${includedir}
	#install -d ${D}${datadir}

	# Copy files to redist
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libnimCodecs.so ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libnimCodecs.so.0 ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libnimMockNodes.so ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libnimMockNodes.so.0 ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libnimRecorder.so ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libnimRecorder.so.0 ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libOpenNI.so ${D}${libdir}
	install -m 755 ${B}/Platform/Linux/Bin/*-Release/libOpenNI.so.0 ${D}${libdir}

	install -m 755 ${S}/Include/*.h ${D}${includedir}

        # TODO: Make this arch-specific
	install -d ${D}${includedir}/openni
	install -d ${D}${includedir}/openni/Linux-AArch64
	install -m 400 ${S}/Include/Linux-AArch64/* ${D}${includedir}
	install -d ${D}${includedir}/openni/Linux-Arm
	install -m 400 ${S}/Include/Linux-Arm/* ${D}${includedir}
	install -d ${D}${includedir}/openni/Linux-Loongarch64
	install -m 400 ${S}/Include/Linux-Loongarch64/* ${D}${includedir}
	install -d ${D}${includedir}/openni/Linux-Mips
	install -m 400 ${S}/Include/Linux-Mips/* ${D}${includedir}
	install -d ${D}${includedir}/openni/Linux-Powerpc
	install -m 400 ${S}/Include/Linux-Powerpc/* ${D}${includedir}
	install -d ${D}${includedir}/openni/Linux-Riscv64
	install -m 400 ${S}/Include/Linux-Riscv64/* ${D}${includedir}
	install -d ${D}${includedir}/openni/Linux-x86
	install -m 400 ${S}/Include/Linux-x86/* ${D}${includedir}
}

FILES:${PN}-dev = "${includedir}"
FILES:${PN} += " \
  ${libdir}/libnimMockNodes.so \
  ${libdir}/libnimCodecs.so \
  ${libdir}/libOpenNI.so \
  ${libdir}/libnimRecorder.so \
"
