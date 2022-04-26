# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS += " \
    fastcdr \
"

# ERROR: do_package: QA Issue: rosidl-adapter: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_typesupport_fastrtps_cpp \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_typesupport_fastrtps_cpp-2.2.0-py3.9.egg-info \
"
