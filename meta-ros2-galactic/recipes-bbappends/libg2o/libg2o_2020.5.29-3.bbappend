# Copyright (c) 2020-2021 LG Electronics, Inc.

DEPENDS += "libglu"

# Don't try to read /proc/cpuinfo as we're cross-compling
EXTRA_OECMAKE += " \
    -DDO_SSE_AUTODETECT=OFF \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse2", "", "-DDISABLE_SSE2=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse3", "", "-DDISABLE_SSE3=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.1", "", "-DDISABLE_SSE4_1=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.2", "", "-DDISABLE_SSE4_2=ON", d)} \
    ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.A", "", "-DDISABLE_SSE4_A=ON", d)} \
"

# stage bindir as well, because g2oTargets-release.cmake checks for g2o,
# g2o_simulator2d, g2o_simulator3d, g2o_anonymize_observations even when it's not
# called during the build (so we don't need to use libg2o-native to provide them)
#
# list(APPEND _IMPORT_CHECK_FILES_FOR_g2o::g2o_cli_application "${_IMPORT_PREFIX}/bin/g2o" )
# list(APPEND _IMPORT_CHECK_FILES_FOR_g2o::g2o_simulator2d_application "${_IMPORT_PREFIX}/bin/g2o_simulator2d" )
# list(APPEND _IMPORT_CHECK_FILES_FOR_g2o::g2o_simulator3d_application "${_IMPORT_PREFIX}/bin/g2o_simulator3d" )
# list(APPEND _IMPORT_CHECK_FILES_FOR_g2o::g2o_anonymize_observations_application "${_IMPORT_PREFIX}/bin/g2o_anonymize_observations" )
SYSROOT_DIRS:append = " \
    ${bindir} \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Rainer-issues508-512.patch"
