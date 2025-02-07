# Copyright (c) 2020-2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-sdl2.patch"

inherit pkgconfig

# QA Issue: File /opt/ros/rolling/share/joy/cmake/export_joyExport.cmake in package joy-dev contains reference to TMPDIR [buildpaths]
# QA Issue: File /opt/ros/rolling/share/joy/cmake/export_game_controllerExport.cmake in package joy-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/joy/cmake/export_joyExport.cmake
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/joy/cmake/export_game_controllerExport.cmake
}
