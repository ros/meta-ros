# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_introspection_c.so contained in package raspimouse-msgs requires librosidl_typesupport_introspection_c.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_introspection_cpp.so contained in package raspimouse-msgs requires librosidl_typesupport_introspection_cpp.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_generator_c.so contained in package raspimouse-msgs requires librcutils.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_c.so contained in package raspimouse-msgs requires librosidl_typesupport_c.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_cpp.so contained in package raspimouse-msgs requires librosidl_typesupport_cpp.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_fastrtps_c.so contained in package raspimouse-msgs requires librosidl_typesupport_fastrtps_c.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_fastrtps_cpp.so contained in package raspimouse-msgs requires libfastcdr.so.1()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_introspection_cpp.so contained in package raspimouse-msgs requires librosidl_runtime_c.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: QA Issue: /usr/lib/libraspimouse_msgs__rosidl_typesupport_fastrtps_cpp.so contained in package raspimouse-msgs requires librosidl_typesupport_fastrtps_cpp.so()(64bit), but no providers found in RDEPENDS:raspimouse-msgs? [file-rdeps]
# ERROR: raspimouse-msgs-1.1.2-1-r0 do_package_qa: Fatal QA errors were found, failing task.
# ERROR: Logfile of failure stored in: TOPDIR/tmp-glibc/work/core2-64-oe-linux/raspimouse-msgs/1.1.2-1-r0/temp/log.do_package_qa.3219035
# ERROR: Task (TOPDIR/meta-ros/meta-ros2-humble/generated-recipes/raspimouse2/raspimouse-msgs_1.1.2-1.bb:do_package_qa) failed with exit code '1'
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
