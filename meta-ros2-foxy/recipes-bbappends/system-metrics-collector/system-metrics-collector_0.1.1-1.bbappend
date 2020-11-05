# Copyright (c) 2020 LG Electronics, Inc.

# "rosidl-default-generators" belongs in ROS_BUILDTOOL_DEPENDS (as "rosidl-default-generators-native"); it should not be in
# ROS_BUILD_DEPENDS.
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
ROS_BUILD_DEPENDS_remove = "rosidl-default-generators"

# FAILED: rosidl_typesupport_fastrtps_cpp/system_metrics_collector/msg/detail/dds_fastrtps/dummy_message__type_support.cpp rosidl_typesupport_fastrtps_cpp/system_metrics_collector/msg/detail/dummy_message__rosidl_typesupport_fastrtps_cpp.hpp
# cd /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/system-metrics-collector/0.1.1-1-r0/build && /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/system-metrics-collector/0.1.1-1-r0/recipe-sysroot-native/usr/bin/python3-native/python3 /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/system-metrics-collector/0.1.1-1-r0/recipe-sysroot/usr/lib/rosidl_typesupport_fastrtps_cpp/rosidl_typesupport_fastrtps_cpp --generator-arguments-file /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/system-metrics-collector/0.1.1-1-r0/build/rosidl_typesupport_fastrtps_cpp__arguments.json
# Traceback (most recent call last):
#   File "/jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/system-metrics-collector/0.1.1-1-r0/recipe-sysroot/usr/lib/rosidl_typesupport_fastrtps_cpp/rosidl_typesupport_fastrtps_cpp", line 6, in <module>
#     from rosidl_typesupport_fastrtps_cpp import generate_cpp
# ModuleNotFoundError: No module named 'rosidl_typesupport_fastrtps_cpp'
DEPENDS += " \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
"
