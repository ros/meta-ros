# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-cmake-native \
    rosidl-generator-cpp-native \
"

# for rmw-implementation
BBCLASSEXTEND = "native"
