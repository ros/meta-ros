inherit ros_ament_cmake

ROS_BUILDTOOL_DEPENDS:append = " \
    python3-numpy-native \
    python3-native \
"

ROS_BUILD_DEPENDS:append = " \
    python3-numpy \
"

EXTRA_OECMAKE:append = " -DPython3_NumPy_INCLUDE_DIR=${STAGING_DIR_TARGET}/usr/include/python3.9 "