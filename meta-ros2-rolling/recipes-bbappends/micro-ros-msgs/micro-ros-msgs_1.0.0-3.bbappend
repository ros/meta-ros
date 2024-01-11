# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_introspection_cpp.so contained in package micro-ros-msgs requires librosidl_runtime_c.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_generator_c.so contained in package micro-ros-msgs requires librcutils.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_c.so contained in package micro-ros-msgs requires librosidl_typesupport_c.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_cpp.so contained in package micro-ros-msgs requires librosidl_typesupport_cpp.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_fastrtps_c.so contained in package micro-ros-msgs requires librosidl_typesupport_fastrtps_c.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_fastrtps_cpp.so contained in package micro-ros-msgs requires libfastcdr.so.1()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_fastrtps_cpp.so contained in package micro-ros-msgs requires librosidl_typesupport_fastrtps_cpp.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_introspection_c.so contained in package micro-ros-msgs requires librosidl_typesupport_introspection_c.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
# QA Issue: /usr/lib/libmicro_ros_msgs__rosidl_typesupport_introspection_cpp.so contained in package micro-ros-msgs requires librosidl_typesupport_introspection_cpp.so()(64bit), but no providers found in RDEPENDS:micro-ros-msgs? [file-rdeps]
ROS_EXEC_DEPENDS += " \
    fastcdr \
    rcutils \
    rosidl-runtime-c \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
"
