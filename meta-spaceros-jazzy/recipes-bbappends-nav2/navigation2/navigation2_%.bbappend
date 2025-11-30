# Copyright (c) 2025 Wind River Systems, Inc.

# nav2-rviz-plugins depends on Qt
ROS_EXEC_DEPENDS:remove = "nav2-rviz-plugins"

# nav2-constrained-smoother depends on openblas
# openblas has difficulty building for riscv64
ROS_EXEC_DEPENDS:remove = "nav2-constrained-smoother"
