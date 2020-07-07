# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "eigen3-cmake-module"

# WARNING: robot-localization-3.0.2-1-r0 do_package_qa: QA Issue: non -staticdev package contains static .a library: robot-localization path '/work/core2-64-oe-linux/robot-localization/3.0.2-1-r0/packages-split/robot-localization/usr/lib/robot_localization/librl_lib.a' [staticdev]
FILES_${PN}-staticdev += "${libdir}/${ROS_BPN}/*.a"
