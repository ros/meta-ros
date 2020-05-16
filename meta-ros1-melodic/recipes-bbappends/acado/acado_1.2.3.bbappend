# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: acado path '/work/qemux86-webos-linux/acado/1.2.3-r0/packages-split/acado/usr/lib/libacado_toolkit_s.so' [dev-so]
inherit ros_insane_dev_so

# tries to execute some code generator during cross-compilation and fails acado/1.2.3-r0/git/examples/code_generation/mpc_mhe/code_generation_crane_kul_mhe: not found
EXTRA_OECMAKE += "-DACADO_WITH_EXAMPLES=OFF"

DEPENDS_append_class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: acado-1.2.3-r0 do_package_qa: QA Issue: acado: /work/core2-64-oe-linux/acado/1.2.3-r0/packages-split/acado/usr/lib/libacado_toolkit_s.so.1.2.2beta contains probably-redundant RPATH /usr/lib [useless-rpaths]
do_install_append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-cmake-CompilerOptions.cmake-don-t-set-march-native.patch"
