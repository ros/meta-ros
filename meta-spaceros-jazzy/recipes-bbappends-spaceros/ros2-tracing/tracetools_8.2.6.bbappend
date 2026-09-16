# Copyright (c) 2024 Wind River Systems, Inc.

# Disable tracepoints when building tracetools-native
EXTRA_OECMAKE:class-native +=  "-DTRACETOOLS_TRACEPOINTS_EXCLUDED=TRUE"
ROS_BUILD_DEPENDS:remove:class-native = "lttng-ust"
ROS_EXEC_DEPENDS:remove:class-native = "lttng-ust"
ROS_EXPORT_DEPENDS:remove:class-native = "lttng-ust"
ROS_EXEC_DEPENDS:remove:class-native = "lttng-tools"
