# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS:remove = "rmw-connext-cpp"
ROS_BUILD_DEPENDS:remove = "rmw-opensplice-cpp"

ROS_EXPORT_DEPENDS:remove = "rmw-opensplice-cpp"
ROS_EXEC_DEPENDS:remove = "rmw-opensplice-cpp"

ROS_BUILD_DEPENDS:append = "rosidl-adapter-native"
ROS_EXEC_DEPENDS:append = " rmw-fastrtps-cpp"
