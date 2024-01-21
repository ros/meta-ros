DESCRIPTION = "OpenNI2 framework"
HOMEPAGE = "https://github.com/structureio/OpenNI2"
LICENSE = "Apache-2.0 & LGPL-2.1-only & Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://ThirdParty/PSCommon/XnLib/ThirdParty/libusb-1.0.9-Android/COPYING;md5=fbc093901857fcd118f065f900982c24 \
                    file://debian/copyright;md5=3bb3d5d1304eba74f9ee6e3c5d573fde"

SRC_URI = " \
    git://salsa.debian.org/multimedia-team/openni2.git;protocol=https;branch=master \
    file://libopenni2.pc \
    file://0000-Disable-java-wrapper.patch \
    file://0001-Add-SONAME-to-libraries.patch \
    file://0002-Change-path-of-config-files-to-etc-openni2.patch \
    file://0003-Use-system-wide-libjpeg.patch \
    file://0004-disable-rpath.patch \
    file://0006-rpi-Added-Armv6l-as-new-target-platform-and-created-missing-OniPlatformLinux-Arm.h-header.patch \
    file://0006-Disable-SSE.patch \
    file://0007-Link-NiViewer-against-ptherad-DSO-on-Ubuntu-raring.patch \
    file://0008-Add-unused-attribute-to-fix-compilation-with-gcc-4.8.patch \
    file://0009-Add-ARMhf-support.patch \
    file://0011-Mark-variables-unused.patch \
    file://0012-generic-linux.patch \
    file://0013-Fix-GCC6-compilation.patch \
    file://0014-fix-format-overflow-for-GCC7.patch \
    file://0015-Initialize-variable-for-gcc7.patch \
    file://0016-Use-the-generic-platform-for-armel-armhf-NEON-is-not.patch \
    file://0017-Port-to-Python-3.patch \
    file://0018-Don-t-allocate-m_errorBuffer-on-TLS.patch \
    file://0018-Fix-javadoc-with-Java-17.patch \
    file://0019-fix-stringop-overflow.patch \
"
SRC_URI[sha256sum] = "abc17f5e30d6799200c69a52d34aefaef4fd567be7921e0cb68cae353ac4495a"

PV = "2.2.0.33+git${SRCPV}"
SRCREV = "73f61583c04328b12c8e4d28c7c854cccafb9ff6"

DEPENDS = " \
  doxygen-native \
  graphviz \
  libjpeg-turbo \
  libtinyxml \
  libusb \
  mesa \
  freeglut \
"

S = "${WORKDIR}/git"

# There are 54 uses of the register identifier which is no longer permitted by ISO C++17
# ../../ThirdParty/LibJPEG/jccolor.c: In function 'void rgb_ycc_convert(j_compress_ptr, JSAMPARRAY, JSAMPIMAGE, JDIMENSION, int)':
# ../../ThirdParty/LibJPEG/jccolor.c:135:16: error: ISO C++17 does not allow 'register' storage class specifier [-Werror=register]
#   135 |   register int r, g, b;
#       |                ^
CFLAGS += "-Wno-error=register"

# LinkProtoLib/XnLink24zYuv422Parser.cpp: In member function 'virtual XnStatus xn::Link24zYuv422Parser::ParsePacketImpl(XnLinkFragmentation, const XnUInt8*, const XnUInt8*, XnUInt8*&, const XnUInt8*)':
# LinkProtoLib/XnLink24zYuv422Parser.cpp:45:50: error: bitwise comparison always evaluates to true [-Werror=tautological-compare]
#    45 |         if ((fragmentation | XN_LINK_FRAG_BEGIN) != 0)
#       |             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ^~ ~
#       | LinkProtoLib/XnLink24zYuv422Parser.cpp:91:48: error: bitwise comparison always evaluates to true [-Werror=tautological-compare]
#    91 |         if ((fragmentation | XN_LINK_FRAG_END) != 0)
#       |             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ^~ ~
CFLAGS += "-Wno-error=tautological-compare"

# DDK/XnDeviceModule.cpp: In member function 'virtual XnStatus XnDeviceModule::GetProperty(XnUInt32, XnUInt64*) const':
# DDK/XnDeviceModule.cpp:169:34: error: 'pProp' may be used uninitialized [-Werror=maybe-uninitialized]
#   169 |         nRetVal = pProp->GetValue(pnValue);
#       |                   ~~~~~~~~~~~~~~~^~~~~~~~~
# DDK/XnDeviceModule.cpp:165:24: note: 'pProp' declared here
#   165 |         XnIntProperty* pProp;
#       |                        ^~~~~
CFLAGS += "-Wno-error=maybe-uninitialized"

# OniDevice.cpp:223:44: error: dangling pointer 'data' to 'seek' may be used [-Werror=dangling-pointer=]
# OniDriverHandler.h:167:54: error: dangling pointer 'data' to 'seek' may be used [-Werror=dangling-pointer=]
CFLAGS += "-Wno-error=dangling-pointer"

do_install () {
  install -d ${D}${libdir}
  install -m 0755 Bin/*-Release/libOpenNI2.so.* ${D}${libdir}
  ln -sf libOpenNI2.so.0 ${D}${libdir}/libOpenNI2.so

  install -d ${D}${libdir}/OpenNI2/Drivers
  install -m 0755 Bin/*-Release/OpenNI2/Drivers/libDummyDevice.so.0 ${D}${libdir}/OpenNI2/Drivers/
  ln -sf  libDummyDevice.so.0 ${D}${libdir}/OpenNI2/Drivers/libDummyDevice.so
  install -m 0755 Bin/*-Release/OpenNI2/Drivers/libOniFile.so.0 ${D}${libdir}/OpenNI2/Drivers/
  ln -sf  libOniFile.so.0 ${D}${libdir}/OpenNI2/Drivers/libOniFile.so
  install -m 0755 Bin/*-Release/OpenNI2/Drivers/libPS1080.so.0 ${D}${libdir}/OpenNI2/Drivers/
  ln -sf  libPS1080.so.0 ${D}${libdir}/OpenNI2/Drivers/libPS1080.so
  install -m 0755 Bin/*-Release/OpenNI2/Drivers/libPSLink.so.0 ${D}${libdir}/OpenNI2/Drivers/
  ln -sf  libPSLink.so.0 ${D}${libdir}/OpenNI2/Drivers/libPSLink.so

  install -d ${D}${sysconfdir}/openni2/
  install -m 0600 Config/*.ini ${D}${sysconfdir}/openni2/

  install -d ${D}${includedir}/openni2/Driver/
  install -m 0600 Include/Driver/* ${D}${includedir}/openni2/Driver
  install -d ${D}${includedir}/openni2/Linux-Arm
  install -m 0600 Include/Linux-Arm/* ${D}${includedir}/openni2/Linux-Arm
  install -d ${D}${includedir}/openni2/Linux-generic
  install -m 0600 Include/Linux-generic/* ${D}${includedir}/openni2/Linux-generic
  install -d ${D}${includedir}/openni2/Linux-x86
  install -m 0600 Include/Linux-x86/* ${D}${includedir}/openni2/Linux-x86
  install -m 0600 Include/*.h ${D}${includedir}/openni2/

  install -d ${D}${datadir}/pkgconfig
  install -m 0600 ${WORKDIR}/libopenni2.pc ${D}${datadir}/pkgconfig

  install -d ${D}${bindir}
  install -m 0755 Bin/*-Release/NiViewer ${D}${bindir}
}

PACKAGES =+ "${PN}-utils"
FILES:${PN} += "${libdir}/OpenNI2/Drivers/lib*.so.0"
FILES:${PN}-dev += "${libdir}/OpenNI2/Drivers/lib*.so"
FILES:${PN}-utils = "${bindir}/NiViewer2"
