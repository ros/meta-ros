# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"

# ERROR: bondcpp-4.1.2-r0 do_package_qa: QA Issue: File /opt/ros/spaceros/share/bondcpp/cmake/bondcppExport.cmake in package bondcpp-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}/uuid##g" ${D}${ros_prefix}/share/bondcpp/cmake/bondcppExport.cmake
}

inherit pkgconfig
