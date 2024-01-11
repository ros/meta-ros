# Copyright (c) 2022-2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-cmake-native \
    rosidl-default-generators-native \
"

# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_generator_c.so contained in package rcgcrd-spl-4 requires librcutils.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_c.so contained in package rcgcrd-spl-4 requires librosidl_typesupport_c.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_cpp.so contained in package rcgcrd-spl-4 requires librosidl_typesupport_cpp.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_fastrtps_c.so contained in package rcgcrd-spl-4 requires librosidl_typesupport_fastrtps_c.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_fastrtps_cpp.so contained in package rcgcrd-spl-4 requires libfastcdr.so.1()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_introspection_cpp.so contained in package rcgcrd-spl-4 requires librosidl_runtime_c.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_fastrtps_cpp.so contained in package rcgcrd-spl-4 requires librosidl_typesupport_fastrtps_cpp.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_introspection_c.so contained in package rcgcrd-spl-4 requires librosidl_typesupport_introspection_c.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
# QA Issue: /usr/lib/librcgcrd_spl_4__rosidl_typesupport_introspection_cpp.so contained in package rcgcrd-spl-4 requires librosidl_typesupport_introspection_cpp.so()(64bit), but no providers found in RDEPENDS:rcgcrd-spl-4? [file-rdeps]
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
