SUMMARY = "Implement the ROS middleware interface using eProsima FastRTPS static code generation in C++."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

DEPENDS = " \
    ament-cmake-ros \
    rcutils \
    fastrtps-cmake-module \
    fastrtps \
    fastcdr \
    rmw \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    rosidl-cmake \
"

include rmw-fastrtps.inc
