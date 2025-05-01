# Copyright (c) 2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/cho3/acado.git   GIT_TAG 8366e22cd5d815078e8d24f78dbced28b48d7e32
# https://github.com/cho3/hpmpc.git   GIT_TAG abbcf0806e4c8763ab2129a90efd827d194c1b00
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
    git://github.com/ros2-gbp/acado_vendor-release;name=release;${ROS_BRANCH};protocol=https \
    file://0001-CMakeLists.txt-fetch-acado-hpmpc-with-bitbake-fetche.patch \
    git://github.com/cho3/acado.git;protocol=https;name=acado-upstream;destsuffix=git/acado-upstream;branch=submodule \
    file://0001-acado-cmake-CompilerOptions.cmake-don-t-set-march-native.patch;patchdir=acado-upstream \
    git://github.com/cho3/hpmpc.git;protocol=https;name=hpmpc-upstream;destsuffix=git/hpmpc-upstream;branch=submodule \
    file://0001-hpmpc-Don-t-clear-CMAKE_C_FLAGS.patch;patchdir=hpmpc-upstream \
"
SRCREV_release = "ad538a018f18ff378d99d46e8508793b5751ae35"
SRCREV_acado-upstream = "8366e22cd5d815078e8d24f78dbced28b48d7e32"
SRCREV_hpmpc-upstream = "abbcf0806e4c8763ab2129a90efd827d194c1b00"
SRCREV_FORMAT = "release_acado-upstream_hpmpc-upstream"

# ERROR: acado-vendor-1.0.0-3-r0 do_package: QA Issue: acado-vendor: Files/directories were installed but not shipped in any package:
#   /usr/cmake
#   /usr/cmake/hpmpcConfig.cmake
#   /usr/cmake/hpmpcConfig-noconfig.cmake
#   /usr/share/acado
#   /usr/share/acado/external_packages
#   /usr/share/acado/external_packages/qpoases
#   /usr/share/acado/external_packages/qpoases3
#   ....
FILES:${PN}-dev += "${prefix}/cmake/hpmpcConfig* \
    ${datadir}/acado/external_packages/qpoases \
    ${datadir}/acado/external_packages/qpoases3 \
"

# ERROR: acado-vendor-1.0.0-3-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package acado-vendor contains symlink .so '/usr/lib/libacado_toolkit_s.so' [dev-so]
inherit ros_insane_dev_so

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# ERROR: acado-vendor-1.0.0-3-r0 do_package_qa: QA Issue: package acado-vendor contains bad RPATH
# acado-vendor/1.0.0-3-r0/build/acado_external_project_install/lib in file
# acado-vendor/1.0.0-3-r0/packages-split/acado-vendor/usr/lib/libacado_toolkit_s.so.1.2.2beta [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/libacado_toolkit_s*${SOLIBS}
}
