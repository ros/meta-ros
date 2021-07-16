# Copyright (c) 2020-2021 LG Electronics, Inc.

# ERROR: dynamic-edt-3d-1.9.7-1-r0 do_package: QA Issue: dynamic-edt-3d: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/dynamicEDT3D
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# dynamic-edt-3d: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

#   /usr/share/dynamicEDT3D/dynamicEDT3DConfig-version.cmake
#   /usr/share/dynamicEDT3D/dynamicEDT3DConfig.cmake
#   /usr/share/dynamicEDT3D/dynamicEDT3DTargets-release.cmake
#   /usr/share/dynamicEDT3D/dynamicEDT3DTargets.cmake
FILES:${PN}-dev += "${datadir}/dynamicEDT3D"

# ERROR: dynamic-edt-3d-1.9.5-2-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: dynamic-edt-3d path '/work/core2-64-oe-linux/dynamic-edt-3d/1.9.5-2-r0/packages-split/dynamic-edt-3d/usr/lib/libdynamicedt3d.so' [dev-so]
inherit ros_insane_dev_so

# WARNING: dynamic-edt-3d-1.9.5-2-r0 do_package_qa: QA Issue: dynamic-edt-3d: /work/core2-64-oe-linux/dynamic-edt-3d/1.9.5-2-r0/packages-split/dynamic-edt-3d/usr/lib/libdynamicedt3d.so.1.9.5 contains probably-redundant RPATH /usr/lib [useless-rpaths]
DEPENDS:append:class-target = " chrpath-replacement-native"

do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
