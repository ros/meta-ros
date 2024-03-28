# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: QA Issue: ... package gazebo-video-monitor-interfaces requires
# ... libservice_msgs__rosidl_generator_c.so()(64bit),
# ... libservice_msgs__rosidl_generator_py.so()(64bit)
# ... libservice_msgs__rosidl_typesupport_fastrtps_c.so()(64bit)
# ... libservice_msgs__rosidl_typesupport_fastrtps_cpp.so()(64bit)
# ... libservice_msgs__rosidl_typesupport_introspection_c.so()(64bit)
# ... libservice_msgs__rosidl_typesupport_introspection_cpp.so()(64bit)
# but no providers found in RDEPENDS:gazebo-video-monitor-interfaces? [file-rdeps]
ROS_EXEC_DEPENDS += " \
    rosidl-generator-c \
    rosidl-generator-py \
    service-msgs \
"
