# Copyright (c) 2023-2024 Wind River Systems, Inc.

ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-xsimd}"
ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-xtensor}"

CXXFLAGS += "-Wno-error=shadow"

CXXFLAGS += "-Wno-error=non-virtual-dtor"
