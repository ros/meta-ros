# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-explicitly-link-with-openssl.patch"

# nlohmann-json PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
# websocketpp PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS:remove = "websocketpp"
