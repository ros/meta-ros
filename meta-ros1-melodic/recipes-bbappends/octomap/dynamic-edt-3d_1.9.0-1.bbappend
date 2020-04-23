# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: dynamic-edt-3d-1.9.0-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: dynamic-edt-3d path '/work/aarch64-oe-linux/dynamic-edt-3d/1.9.0-1-r0/packages-split/dynamic-edt-3d/usr/lib/libdynamicedt3d.so' [dev-so]
inherit ros_insane_dev_so

# WARNING: dynamic-edt-3d-1.9.0-1-r0 do_package_qa: QA Issue: dynamic-edt-3d: /work/aarch64-oe-linux/dynamic-edt-3d/1.9.0-1-r0/packages-split/dynamic-edt-3d/usr/lib/libdynamicedt3d.so.1.9.0 contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS_append_class-target = " chrpath-replacement-native"

do_install_append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
