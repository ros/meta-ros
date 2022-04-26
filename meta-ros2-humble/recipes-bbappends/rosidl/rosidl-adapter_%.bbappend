# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS:remove = "ament-cmake"
ROS_BUILDTOOL_DEPENDS += "ament-cmake-native"

# ERROR: rosidl-adapter-3.1.3-1-r0 do_package: QA Issue: rosidl-adapter: Files/directories were installed but not shipped in any package
FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_adapter-3.1.3-py3.9.egg-info \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_adapter \
"
