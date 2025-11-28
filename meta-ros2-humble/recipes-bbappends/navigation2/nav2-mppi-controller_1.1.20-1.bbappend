# Copyright (c) 2023 Wind River Systems, Inc.

ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-xsimd}"
ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-xtensor}"

# error: 'ret' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"

# error: 'void* __builtin_memcpy(void*, const void*, long unsigned int)' forming offset 8 is out of the bounds [0, 8] of object 'shape' with type 'index_type' {aka 'std::array<long unsigned int, 1>'} [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"
