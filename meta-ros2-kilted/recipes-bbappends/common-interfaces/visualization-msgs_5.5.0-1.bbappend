# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    python3-numpy-native \
    python3-lark-parser-native \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"

# Fix QA Issue with missing dependency, "but no providers found in RDEPENDS:diagnostic-msgs? [file-rdeps]"
ROS_EXEC_DEPENDS += " \
    service-msgs \
"
