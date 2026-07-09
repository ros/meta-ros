# Copyright (c) 2021 LG Electronics, Inc.

inherit pkgconfig

do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}/uuid##g" ${D}${ros_prefix}/share/bondcpp/cmake/bondcppExport.cmake
}
