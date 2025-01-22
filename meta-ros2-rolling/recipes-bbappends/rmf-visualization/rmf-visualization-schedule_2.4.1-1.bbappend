# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# nlohmann-json PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
# websocketpp PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS:remove = "websocketpp"

inherit pkgconfig
