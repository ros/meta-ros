# Copyright (c) 2021 LG Electronics, Inc.

EXTRA_OECMAKE += "-Dros_industrial_cmake_boilerplate_DIR=${STAGING_LIBDIR}/cmake/ros_industrial_cmake_boilerplate"

# it's only in ROS_TEST_DEPENDS and we have testing disabled. CMake tries to find it even with testing disabled.
DEPENDS += "tesseract-support"

# ERROR: tesseract-geometry-0.4.1-1-r0 do_package: QA Issue: tesseract-geometry: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/tesseract_geometry
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# tesseract-geometry: 4 installed and not shipped files. [installed-vs-shipped]
do_install:append() {
    rm -rf ${D}${datadir}/ament_index
}
