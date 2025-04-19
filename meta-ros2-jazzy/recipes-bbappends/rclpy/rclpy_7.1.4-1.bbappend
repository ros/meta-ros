# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

inherit python3targetconfig

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-generator-py-native \
"

# Set CMAKE_BUILD_TYPE to prevent pybind11Common.cmake:pybind11_strip()
# from stripping the binary. This fixes a QA issue:
# ERROR: rclpy-5.4.0-1-r0 do_package: QA Issue: File '/usr/lib/python3.11/site-packages/rclpy/_rclpy_pybind11.cpython-311-x86_64-linux-gnu.so' from rclpy was already stripped, this will prevent future debugging! [already-stripped]
EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=DEBUG"
