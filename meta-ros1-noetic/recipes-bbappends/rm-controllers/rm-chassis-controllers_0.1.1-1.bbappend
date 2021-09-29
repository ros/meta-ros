# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += "nav-msgs"

# webos-noetic-honister/tmp-glibc/work/raspberrypi4-webos-linux-gnueabi/rm-chassis-controllers/0.1.1-1-r0/recipe-sysroot/usr/opt/ros/noetic/include/class_loader/meta_object.hpp:198:12: error: 'new' of type 'rm_chassis_controllers::BalanceController' with extended alignment 16 [-Werror=aligned-new=]
# |   198 |     return new C;
# |       |            ^~~~~
CXXFLAGS += "-Wno-error=aligned-new="
