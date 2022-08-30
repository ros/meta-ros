ROS_BUILDTOOL_DEPENDS:append = " \
    python3-native \
    python3-numpy-native \
    rosidl-default-generators-native \    
"

EXTRA_OECMAKE:append = " \
    -DPython3_NumPy_INCLUDE_DIR=${STAGING_DIR_NATIVE}/usr/include/python3.9/numpy \
"