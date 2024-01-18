# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# ERROR: leo-msgs-2.0.0-1-r0 do_package_qa: QA Issue: ... package leo-msgs requires
# ... libservice_msgs__rosidl_generator_c.so()(64bit),
# ... libservice_msgs__rosidl_generator_py.so()(64bit),
# ... libservice_msgs__rosidl_typesupport_fastrtps_c.so()(64bit),
# ... libservice_msgs__rosidl_typesupport_fastrtps_cpp.so()(64bit),
# ... libservice_msgs__rosidl_typesupport_introspection_c.so()(64bit),
# ... libservice_msgs__rosidl_typesupport_introspection_cpp.so()(64bit),
# but no providers found in RDEPENDS:leo-msgs? [file-rdeps]
ROS_EXEC_DEPENDS += " \
    builtin-interfaces \
    fastcdr \
    rcutils \
    rosidl-runtime-c \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    service-msgs \
"
