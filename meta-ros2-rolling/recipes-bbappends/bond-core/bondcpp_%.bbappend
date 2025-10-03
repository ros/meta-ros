# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-runtime-native \
"

do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}/uuid##g" ${D}${ros_prefix}/share/bondcpp/cmake/bondcppExport.cmake
}

inherit pkgconfig
