# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "zenoh-c zenoh-cpp"

EXTRA_OECMAKE += " -DUSE_SYSTEM_ZENOH=ON"
