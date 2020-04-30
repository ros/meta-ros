# Copyright (c) 2020 LG Electronics, Inc.

# uncrustify appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_uncrustify}"
ROS_EXEC_DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_uncrustify}"
