# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-system-component-from-boost-package.patch"

# ERROR: warehouse-ros-sqlite-1.0.5-r0 do_package_qa: QA Issue: File /opt/ros/spaceros/share/warehouse_ros_sqlite/cmake/export_warehouse_ros_sqliteExport.cmake in package warehouse-ros-sqlite-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}##g" ${D}${ros_prefix}/share/warehouse_ros_sqlite/cmake/export_warehouse_ros_sqliteExport.cmake
}
