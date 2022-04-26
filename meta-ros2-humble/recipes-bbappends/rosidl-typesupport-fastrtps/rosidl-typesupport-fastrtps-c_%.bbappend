# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# Without the target rosidl-typesupport-fastrtps-cpp, ament finds the native packages and then fails to link
# (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    fastcdr \
    rosidl-typesupport-fastrtps-cpp \
"

# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
#PNQAFIX = "rosidl_typesupport_fastrtps_c"
#FILES:${PN}:prepend = " \
#    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/${PNQAFIX} \
#    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/${PNQAFIX}-2.2.0-py3.9.egg-info \
#"
