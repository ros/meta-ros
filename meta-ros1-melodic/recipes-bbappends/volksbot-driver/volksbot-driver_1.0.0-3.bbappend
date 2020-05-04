# Copyright (c) 2020 LG Electronics, Inc.

do_configure_prepend() {
    # The paths returned by LibEPOS2Config.cmake aren't properly prefixed with sysroot path
    sed '/^include(.{LIBEPOS2_USE_FILE})$/d' -i ${S}/CMakeLists.txt
    sed 's#^include_directories(.{catkin_INCLUDE_DIRS} include/)$#include_directories($''{catkin_INCLUDE_DIRS} include/ ${RECIPE_SYSROOT}/$''{LIBEPOS2_INCLUDE_DIRS})#g' -i ${S}/CMakeLists.txt
    sed 's#^target_link_libraries(volksbot .{LIBEPOS2_LIBRARIES} .{catkin_LIBRARIES})$#target_link_libraries(volksbot ${RECIPE_SYSROOT}/$''{LIBEPOS2_LIBRARIES} $''{catkin_LIBRARIES})#g' -i ${S}/CMakeLists.txt
}
