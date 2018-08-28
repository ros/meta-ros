SUMMARY = "The ROS client library common interfaces."
HOMEPAGE = "https://github.com/ros2/rcl_interfaces"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"
DEPENDS = " \
    rosidl-default-generators \
    rosidl-cmake \
    rosidl-parser \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-py \
    rmw-implementation-cmake \
    rmw \
    rmw-fastrtps-cpp \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    python-cmake-module \
"

SRCREV = "53cd9455efebf9fc78a23cd7d20d9af2b57688f0"
SRC_URI = "git://github.com/ros2/rcl_interfaces.git;protocol=git;"

inherit ament pythonpath-insane
