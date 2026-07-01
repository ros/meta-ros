# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
"

# nav2-msgs/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"
