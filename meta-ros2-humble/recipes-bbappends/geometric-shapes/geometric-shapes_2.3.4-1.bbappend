# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-octomap-dependency.patch"

# ERROR: geometric-shapes-2.0.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: geometric-shapes path '/work/raspberrypi4-webos-linux-gnueabi/geometric-shapes/2.0.0-1-r0/packages-split/geometric-shapes/usr/lib/libgeometric_shapes.so' [dev-so]
inherit ros_insane_dev_so

do_install:append() {
    # Fix for QA warning [buildpaths]
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}#${includedir}#g" ${D}${ros_datadir}/geometric_shapes/cmake/export_geometric_shapesExport.cmake
    sed -i -e "s#${RECIPE_SYSROOT}${ros_includedir}#${ros_includedir}#g" ${D}${ros_datadir}/geometric_shapes/cmake/export_geometric_shapesExport.cmake
    sed -i -e "s#${RECIPE_SYSROOT}${ros_libdir}#${ros_libdir}#g" ${D}${ros_datadir}/geometric_shapes/cmake/export_geometric_shapesExport.cmake
}
