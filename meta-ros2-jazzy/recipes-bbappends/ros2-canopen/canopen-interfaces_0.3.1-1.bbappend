# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# QA Issue: ... package canopen-interfaces requires libbuiltin_interfaces__rosidl_generator_c.so()(64bit), but no providers found in RDEPENDS:canopen-interfaces? [file-rdeps]
# ... requires librcutils.so()(64bit)
# ... requires librosidl_typesupport_c.so()(64bit)
# ... requires librosidl_typesupport_cpp.so()(64bit)
# ... requires libfastcdr.so.1()(64bit)
# ... requires librosidl_typesupport_fastrtps_c.so()(64bit)
# ... requires librosidl_runtime_c.so()(64bit)
# ... requires librosidl_typesupport_fastrtps_cpp.so()(64bit)
# ... requires librosidl_typesupport_introspection_c.so()(64bit)
# ... requires librosidl_typesupport_introspection_cpp.so()(64bit)
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
