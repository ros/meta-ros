# Copyright (c) 2024 Wind River Systems, Inc.

# tracetools/8.2.0-1/build/include/tracetools/tp_call.h:480:5: error: initialization of 'const uint64_t *' {aka 'const long unsigned int *'} from 'uint64_t' {aka 'long unsigned int'} makes pointer from integer without a cast [-Wint-conversion]
CFLAGS += "-Wno-error=int-conversion"

# Disable tracepoints when building tracetools-native
EXTRA_OECMAKE:class-native +=  "-DTRACETOOLS_TRACEPOINTS_EXCLUDED=TRUE"
ROS_BUILD_DEPENDS:remove:class-native = "lttng-ust"
ROS_EXEC_DEPENDS:remove:class-native = "lttng-ust"
ROS_EXPORT_DEPENDS:remove:class-native = "lttng-ust"
ROS_EXEC_DEPENDS:remove:class-native = "lttng-tools"
