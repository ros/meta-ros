# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"

# polygon-rviz-plugins fails to link with:
#   libcolor_util.a(convert.cpp.o): relocation R_X86_64_32 against `.rodata.str1.1' can not be used when making a shared object; recompile with -fPIC
#   ld: failed to set dynamic section sizes: bad value
CXXFLAGS += "-fPIC"
