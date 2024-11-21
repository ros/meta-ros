# Copyright (c) 2020 LG Electronics, Inc.

LICENSE = "BSD-2-Clause"

PACKAGECONFIG ?= "${@bb.utils.filter('DISTRO_FEATURES', 'opengl', d)}"
PACKAGECONFIG[opengl] = "-DG2O_USE_OPENGL=ON,-DG2O_USE_OPENGL=OFF,libglu"

DEPENDS_TO_REMOVE = "${@bb.utils.contains('PACKAGECONFIG', 'opengl', '', 'mesa libglu', d)}"
DEPENDS:remove = "${DEPENDS_TO_REMOVE}"
RDEPENDS:${PN}:remove = "${DEPENDS_TO_REMOVE}"

# Don't try to read /proc/cpuinfo as we're cross-compling
EXTRA_OECMAKE += " \
    -DDO_SSE_AUTODETECT=OFF \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse2", "", "-DDISABLE_SSE2=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse3", "", "-DDISABLE_SSE3=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.1", "", "-DDISABLE_SSE4_1=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.2", "", "-DDISABLE_SSE4_2=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.A", "", "-DDISABLE_SSE4_A=ON", d)} \
"

# non -dev/-dbg/nativesdk- package libg2o contains symlink .so '/usr/lib/libg2o_stuff.so'
FILES:${PN}-dev += " \
    ${ros_libdir}/libg2o*.so \
"
