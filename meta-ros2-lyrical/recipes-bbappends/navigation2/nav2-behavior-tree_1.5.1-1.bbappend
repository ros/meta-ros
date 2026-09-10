# Copyright (c) 2026 Wind River Systems, Inc.

# nav2-behavior-tree/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/rosidl_runtime_cpp/rosidl_runtime_cpp/traits.hpp:132:8: error: 'template<class _Codecvt, class _Elem, class _Wide_alloc, class _Byte_alloc> class std::__cxx11::wstring_convert' is deprecated [-Werror=deprecated-declarations]
CXXFLAGS += "-Wno-error=deprecated-declarations"

# nav2-behavior-tree/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/rclcpp/rclcpp/exceptions/exceptions.hpp:71:79: error: declaration of 'invalid_index' shadows a member of 'rclcpp::exceptions::InvalidNodeNameError' [-Werror=shadow]
CXXFLAGS += "-Wno-error=shadow"

# nav2-behavior-tree/1.4.2-1/recipe-sysroot/usr/include/c++/15.2.0/bits/new_allocator.h:172:66: error: 'void operator delete(void*, std::size_t)' called on unallocated object 'res' [-Werror=free-nonheap-object]
CXXFLAGS += "-Wno-error=free-nonheap-object"

# nav2-behavior-tree/1.4.2-1/recipe-sysroot/opt/ros/kilted/include/builtin_interfaces/builtin_interfaces/msg/detail/time__struct.hpp:125:28: error: potential null pointer dereference [-Werror=null-dereference]
CXXFLAGS += "-Wno-error=null-dereference"
