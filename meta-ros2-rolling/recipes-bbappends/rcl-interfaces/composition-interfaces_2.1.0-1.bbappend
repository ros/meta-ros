# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

# Fix QA Issue with missing dependency, "but no providers found in RDEPENDS:diagnostic-msgs? [file-rdeps]"
ROS_EXEC_DEPENDS += " \
    service-msgs \
"
