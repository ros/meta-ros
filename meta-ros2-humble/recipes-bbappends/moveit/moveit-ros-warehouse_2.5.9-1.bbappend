# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://remove-boost-system.patch \
            file://add-bullet-dependency.patch"

# ERROR: moveit-ros-warehouse-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-warehouse path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-warehouse/2.1.0-1-r0/packages-split/moveit-ros-warehouse/usr/lib/libmoveit_warehouse.so' [dev-so]
inherit ros_insane_dev_so

do_install:append() {
    # Fix for QA warning [buildpaths]
    # Remove ${RECIPE_SYSROOT}/usr/include added by the Boost components
    sed -i -e "s#${RECIPE_SYSROOT}${includedir};##g" ${D}${ros_datadir}/moveit_ros_warehouse/cmake/moveit_ros_warehouseTargetsExport.cmake
}
