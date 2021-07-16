# Copyright (c) 2021 LG Electronics, Inc.

EXTRA_OECMAKE += "-Dros_industrial_cmake_boilerplate_DIR=${STAGING_LIBDIR}/cmake/ros_industrial_cmake_boilerplate"

# ERROR: tesseract-srdf-0.4.1-1-r0 do_package: QA Issue: tesseract-srdf: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/tesseract_srdf
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# tesseract-srdf: 4 installed and not shipped files. [installed-vs-shipped]
do_install:append() {
    rm -rf ${D}${datadir}/ament_index
}
