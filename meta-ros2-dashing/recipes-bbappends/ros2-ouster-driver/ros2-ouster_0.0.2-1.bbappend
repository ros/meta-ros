# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "jsoncpp"
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-jsoncpp.patch"

# Fails with webOS OSE which by default uses -Werror=return-type
# ros2-ouster/0.0.2-1-r0/git/include/ros2_ouster/interfaces/sensor_interface.hpp:60:43: error: no return statement in function returning non-void [-Werror=return-type]
# ros2-ouster/0.0.2-1-r0/git/include/ros2_ouster/interfaces/sensor_interface.hpp:67:73: error: no return statement in function returning non-void [-Werror=return-type]
# ros2-ouster/0.0.2-1-r0/git/include/ros2_ouster/interfaces/sensor_interface.hpp:73:48: error: no return statement in function returning non-void [-Werror=return-type]
# ros2-ouster/0.0.2-1-r0/git/src/OS1/OS1_sensor.cpp:96:1: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
