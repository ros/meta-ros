# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"

do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}/usr/include/uuid##g" ${D}${ros_prefix}/share/bondcpp/cmake/bondcppExport.cmake
}

inherit pkgconfig
