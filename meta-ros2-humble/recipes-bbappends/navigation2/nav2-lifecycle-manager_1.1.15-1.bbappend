# Copyright (c) 2022-2024 Wind River Systems, Inc.

# nav2-lifecycle-manager/1.1.2-1-r0/recipe-sysroot/usr/include/nav2_msgs/nav2_msgs/srv/detail/manage_lifecycle_nodes__struct.hpp:137:19: error: redundant redeclaration of 'constexpr' static data member 'nav2_msgs::srv::ManageLifecycleNodes_Request_<ContainerAllocator>::STARTUP' [-Werror=deprecated]
CXXFLAGS += "-Wno-error=deprecated"

# nav2-lifecycle-manager/1.1.12-1/recipe-sysroot/usr/include/c++/13.2.0/bits/stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' forming offset 8 is out of the bounds [0, 8] [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

# nav2-lifecycle-manager/1.1.12-1/recipe-sysroot/usr/include/c++/13.2.0/bits/stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' writing between 9 and 9223372036854775807 bytes into a region of size 8 overflows the destination [-Werror=stringop-overflow=]
CXXFLAGS += "-Wno-error=stringop-overflow"
