# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += "python-cmake-module"

# XXX Workaround for a type casting error (PyMethodDef) in rosbag2_transport_python.cpp .
TARGET_CFLAGS += "-Wno-error=cast-function-type"
