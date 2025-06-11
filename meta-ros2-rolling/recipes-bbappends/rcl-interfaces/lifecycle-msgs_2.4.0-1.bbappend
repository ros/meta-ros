# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
    service-msgs \
"

# Fix QA Issue with missing dependency, "but no providers found in RDEPENDS:diagnostic-msgs? [file-rdeps]"
ROS_EXEC_DEPENDS += " \
    builtin-interfaces \
"
