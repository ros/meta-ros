# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-missing-cstdint.patch"

# ERROR: rmf-traffic-2.0.0-2-r0 do_package: QA Issue: rmf-traffic: Files/directories were installed but not shipped in any package:
#  /usr/share/ament_index
#  /usr/share/ament_index/resource_index
#  /usr/share/ament_index/resource_index/packages
#  /usr/share/ament_index/resource_index/packages/rmf_traffic
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rmf-traffic: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

do_install:append() {
    # QA Issue: File /opt/ros/rolling/lib/rmf_traffic/cmake/rmf_traffic-targets.cmake in package rmf-traffic contains reference to TMPDIR [buildpaths]
    sed -i -e "s#${S}/include;##g" ${D}${ros_libdir}/rmf_traffic/cmake/rmf_traffic-targets.cmake
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}#${includedir}#g" ${D}${ros_libdir}/rmf_traffic/cmake/rmf_traffic-targets.cmake
    sed -i -e "s#${B}##g" ${D}${ros_libdir}/rmf_traffic/cmake/rmf_traffic-targets.cmake
}
