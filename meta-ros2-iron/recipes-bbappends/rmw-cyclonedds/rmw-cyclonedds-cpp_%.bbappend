# Copyright (c) 2019 LG Electronics, Inc.

# | /tmp/sandeepg/yocto/2023.1/build-zcu102/work/cortexa72-cortexa53-xilinx-linux/rmw-cyclonedds-cpp/1.3.3-2-r0/git/src/Serialization.cpp:105:10: error: 'memset' is not a member of 'std'; did you mean 'wmemset'?
# |   105 |     std::memset(position, '\0', n_bytes);
# |       |          ^~~~~~
# |       |          wmemset
# | /tmp/sandeepg/yocto/2023.1/build-zcu102/work/cortexa72-cortexa53-xilinx-linux/rmw-cyclonedds-cpp/1.3.3-2-r0/git/src/Serialization.cpp: In member function 'virtual void rmw_cyclonedds_cpp::DataCursor::put_bytes(const void*, std::size_t)':
# | /tmp/sandeepg/yocto/2023.1/build-zcu102/work/cortexa72-cortexa53-xilinx-linux/rmw-cyclonedds-cpp/1.3.3-2-r0/git/src/Serialization.cpp:113:10: error: 'memcpy' is not a member of 'std'; did you mean 'wmemcpy'?
# |   113 |     std::memcpy(position, bytes, n_bytes);
# |       |          ^~~~~~
# |       |          wmemcpy

# Cherry pick patch from rmw_cyclonedds rolling version
# https://github.com/ros2/rmw_cyclonedds/pull/393/commits/d44627e761e557c0b633076b1bd2fb6f6b891bd5

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Fix-Add-cstring-header-for-memset-398.patch;striplevel=2 \
    "

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-cmake-native \
    rosidl-generator-cpp-native \
    rosidl-default-runtime \
"

# for rmw-implementation
BBCLASSEXTEND = "native"
