# Copyright (c) 2020 LG Electronics, Inc.

# find_package(Genicam REQUIRED NO_CMAKE_PATH PATHS ${CMAKE_CURRENT_SOURCE_DIR}/genicam CONFIG NO_DEFAULT_PATH)
# doesn't work for some reason, help it by setting Genicam_DIR
EXTRA_OECMAKE += "-DGenicam_DIR=${S}/genicam"

# These are prebuilt binaries
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libGenApi_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libGCBase_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libNodeMapData_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libXmlParser_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/liblog4cpp_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libLog_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
# ERROR: rc-genicam-api-2.3.3-1-r0 do_package: QA Issue: File '/usr/lib/libMathParser_gcc46_v3_1.so' from rc-genicam-api was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"

# ERROR: rc-genicam-api-2.3.3-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: rc-genicam-api path '/work/raspberrypi4-webos-linux-gnueabi/rc-genicam-api/2.3.3-1-r0/packages-split/rc-genicam-api/usr/lib/librc_genicam_api.so' [dev-so]
inherit ros_insane_dev_so

# ERROR: rc-genicam-api-2.3.3-1-r0 do_package_qa: QA Issue: /usr/share/rc_genicam_api/net_perf_check.sh contained in package rc-genicam-api requires /bin/bash, but no providers found in RDEPENDS:rc-genicam-api? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"

# Uses cxx -dumpmachine to check the target architecture and fails for qemux86
# because it detects i586 and supports only i686 (and arm, aarch64, x86_64)
#   EXECUTE_PROCESS(COMMAND ${CMAKE_CXX_COMPILER} -dumpmachine COMMAND tr -d '\n' OUTPUT_VARIABLE CXX_MACHINE)
#   string(REGEX REPLACE "([a-zA-Z_0-9]+).*" "\\1" ARCHITECTURE ${CXX_MACHINE})
#
# Restrict this recipe with COMPATIBLE_MACHINE and then just force
# ARCHITECTURE with EXTRA_OECMAKE

COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:armv7a = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"
COMPATIBLE_MACHINE:armv7ve = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '(^$)', '(.*)', d)}"

RC_GENICAM_API_ARCHITECTURE:x86-64 = "x86_64"
RC_GENICAM_API_ARCHITECTURE:x86 = "i686"
RC_GENICAM_API_ARCHITECTURE:aarch64 = "aarch64"
RC_GENICAM_API_ARCHITECTURE:armv7a = "arm"
RC_GENICAM_API_ARCHITECTURE:armv7ve = "arm"

# RC_PROJECT_VERSION is set in cmake/project_version.cmake by git describe checking for 'v?([0-9.]+).*' tag
# but in roboception-gbp/rc_genicam_api-release repo there are no suitable tags:
# 2.5.0-1-r0/git$ git describe --all
# tags/release/rolling/rc_genicam_api/2.5.0-1
# so it ends 0.0.0 triggering an warning:
# CMake Warning at cmake/project_version.cmake:124 (message):
# Version from package.xml (2.5.0) doesn't match RC_PROJECT_VERSION (0.0.0)
# and then more importantly rc-genicam-driver error:
# CMake Error at CMakeLists.txt:29 (find_package):
#  Could not find a configuration file for package "RC_GENICAM_API" that is
#  compatible with requested version "2.4.4".
#
#  The following configuration files were considered but not accepted:
#
#    TOPDIR/tmp-glibc/work/qemux86-webos-linux/rc-genicam-driver/0.1.3-1-r0/recipe-sysroot/usr/lib/rc_genicam_api/RC_GENICAM_APIConfig.cmake, version: 0.0.0
RC_PROJECT_VERSION = "${@'${PV}'.split('-')[0]}"

EXTRA_OECMAKE += "-DARCHITECTURE=${RC_GENICAM_API_ARCHITECTURE} -DRC_PROJECT_VERSION=${RC_PROJECT_VERSION}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-GenicamConfig.cmake-detect-ARCHITECTURE-only-when-no.patch"

# in version 2.4.1-1 only aarch64 prebuilt binaries ware missing GNU_HASH, but in 2.5.0-1 it's missing for all 4 supported architectures (32_ARMhf, 32_i86, 64_ARM, 64_x64)
INSANE_SKIP:${PN} += " ldflags"

# rc-genicam-driver/0.1.3-1-r0/recipe-sysroot/usr/lib/rc_genicam_api/RC_GENICAM_APITargets.cmake:110 (message):
# expects the binary to exist:
# The imported target "rc_genicam_api::gc_info" references the file
# "TOPDIR/tmp-glibc/work/core2-64-oe-linux/rc-genicam-driver/0.1.3-1-r0/recipe-sysroot/usr/bin/gc_info"
# OE doesn't stage ${bindir} for target recipes, but in this case the rc_genicam_api::gc_info isn't
# being called during the cross-build, so we can include it just to keep CMake happy
sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}
