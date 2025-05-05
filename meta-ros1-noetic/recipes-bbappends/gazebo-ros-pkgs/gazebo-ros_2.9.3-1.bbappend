# Copyright (c) 2025 Wind River Systems, Inc.

inherit pkgconfig

RDEPENDS:${PN} += "bash"

# ERROR: QA Issue: package gazebo-ros contains bad RPATH .../gazebo-ros/2.9.3-1-r0/recipe-sysroot/usr/lib/gazebo-11/plugins
#     in file .../libgazebo_ros_paths_plugin.so
#     in file .../libgazebo_ros_api_plugin.so
do_install:append() {
    chrpath --delete ${D}${ros_libdir}/libgazebo_ros_paths_plugin.so
    chrpath --delete ${D}${ros_libdir}/libgazebo_ros_api_plugin.so
}
