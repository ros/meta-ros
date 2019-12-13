# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS_remove = "rmw-connext-cpp"
ROS_BUILD_DEPENDS_remove = "rmw-opensplice-cpp"

ROS_EXPORT_DEPENDS_remove = "rmw-opensplice-cpp"
ROS_EXEC_DEPENDS_remove = "rmw-opensplice-cpp"

ROS_BUILD_DEPENDS_append = "rosidl-adapter-native"
ROS_EXEC_DEPENDS_append = " rmw-fastrtps-cpp"
