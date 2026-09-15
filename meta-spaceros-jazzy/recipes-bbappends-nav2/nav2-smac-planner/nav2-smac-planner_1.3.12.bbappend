# Copyright (c) 2026 Wind River Systems, Inc.

do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}${ros_includedir}/ompl-1.7#${ros_includedir}/ompl-1.7#g" ${D}${ros_prefix}/share/nav2_smac_planner/cmake/ament_cmake_export_include_directories-extras.cmake
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}#${includedir}#g" ${D}${ros_prefix}/share/nav2_smac_planner/cmake/ament_cmake_export_include_directories-extras.cmake
}
