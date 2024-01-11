# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"

# QA Issue: /usr/lib/libdynamixel_workbench_msgs__rosidl_generator_c.so contained in package dynamixel-workbench-msgs requires libservice_msgs__rosidl_generator_c.so()(64bit), but no providers found in RDEPENDS:dynamixel-workbench-msgs? [file-rdeps]
# QA Issue: /usr/lib/libdynamixel_workbench_msgs__rosidl_generator_py.so contained in package dynamixel-workbench-msgs requires libservice_msgs__rosidl_generator_py.so()(64bit), but no providers found in RDEPENDS:dynamixel-workbench-msgs? [file-rdeps]
# QA Issue: /usr/lib/libdynamixel_workbench_msgs__rosidl_typesupport_fastrtps_c.so contained in package dynamixel-workbench-msgs requires libservice_msgs__rosidl_typesupport_fastrtps_c.so()(64bit), but no providers found in RDEPENDS:dynamixel-workbench-msgs? [file-rdeps]
# QA Issue: /usr/lib/libdynamixel_workbench_msgs__rosidl_typesupport_fastrtps_cpp.so contained in package dynamixel-workbench-msgs requires libservice_msgs__rosidl_typesupport_fastrtps_cpp.so()(64bit), but no providers found in RDEPENDS:dynamixel-workbench-msgs? [file-rdeps]
# QA Issue: /usr/lib/libdynamixel_workbench_msgs__rosidl_typesupport_introspection_c.so contained in package dynamixel-workbench-msgs requires libservice_msgs__rosidl_typesupport_introspection_c.so()(64bit), but no providers found in RDEPENDS:dynamixel-workbench-msgs? [file-rdeps]
# QA Issue: /usr/lib/libdynamixel_workbench_msgs__rosidl_typesupport_introspection_cpp.so contained in package dynamixel-workbench-msgs requires libservice_msgs__rosidl_typesupport_introspection_cpp.so()(64bit), but no providers found in RDEPENDS:dynamixel-workbench-msgs? [file-rdeps]
ROS_BUILD_DEPENDS += " \
    service-msgs \
"
