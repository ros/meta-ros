# Copyright (c) 2019-2020 LG Electronics, Inc.

#   /usr/share/dynamicEDT3D/dynamicEDT3DConfig-version.cmake
#   /usr/share/dynamicEDT3D/dynamicEDT3DConfig.cmake
#   /usr/share/dynamicEDT3D/dynamicEDT3DTargets-release.cmake
#   /usr/share/dynamicEDT3D/dynamicEDT3DTargets.cmake
FILES:${PN}-dev += "${datadir}/dynamicEDT3D"

# ERROR: dynamic-edt-3d-1.9.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: dynamic-edt-3d path '/work/i586-oe-linux/dynamic-edt-3d/1.9.2-1-r0/packages-split/dynamic-edt-3d/usr/lib/libdynamicedt3d.so' [dev-so]
inherit ros_insane_dev_so

# WARNING: dynamic-edt-3d-1.9.2-1-r0 do_package_qa: QA Issue: dynamic-edt-3d: /work/i586-oe-linux/dynamic-edt-3d/1.9.2-1-r0/packages-split/dynamic-edt-3d/usr/lib/libdynamicedt3d.so.1.9.2 contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"

do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
