# Copyright (c) 2019 LG Electronics, Inc.

# "rosidl-default-generators" belongs in ROS_BUILDTOOL_DEPENDS (as "rosidl-default-generators-native"); it should not be in
# ROS_BUILD_DEPENDS.
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
ROS_BUILD_DEPENDS:remove = "rosidl-default-generators"
