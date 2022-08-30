ROS_BUILDTOOLS_DEPENDS:append = " \
    rosidl-default-generators-native \
    fastrtps-cmake-module-native \
"

EXTRA_OECMAKE += " \
    -Dfastrtps_cmake_module_DIR=${STAGING_DIR_NATIVE}/usr/share/fastrtps_cmake_module/cmake/ \
"