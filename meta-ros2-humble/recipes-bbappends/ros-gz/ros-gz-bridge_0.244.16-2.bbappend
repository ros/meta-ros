# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    protobuf-native \
    launch-native \
    launch-ros-native \
"

inherit python3native

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

do_compile:prepend() {
    export LD_LIBRARY_PATH="${RECIPE_SYSROOT_NATIVE}/${ros_libdir}"
}

# QA Issue: File /opt/ros/humble/share/ros_gz_bridge/cmake/export_ros_gz_bridgeExport.cmake in package ros-gz-bridge-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/ros_gz_bridge/cmake/export_ros_gz_bridgeExport.cmake
}
