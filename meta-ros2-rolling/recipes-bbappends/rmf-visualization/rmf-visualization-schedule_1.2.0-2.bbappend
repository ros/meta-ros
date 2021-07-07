# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-explicitly-link-with-openssl.patch"

# nlohmann-json PN is empty don't add runtime dependency on it
ROS_EXEC_DEPENDS_remove = "nlohmann-json"
