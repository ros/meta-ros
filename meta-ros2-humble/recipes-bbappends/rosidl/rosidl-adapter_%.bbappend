# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS:remove = "ament-cmake"
ROS_BUILDTOOL_DEPENDS += "ament-cmake-native"

ROS_BUILD_DEPENDS += " \
    ament-cmake-test \
"

# ERROR: rosidl-adapter-3.1.3-1-r0 do_package: QA Issue: rosidl-adapter: Files/directories were installed but not shipped in any package
do_install:append:class-target() {
    mkdir -p ${D}/usr/lib/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}/usr/lib/python3.9/site-packages/${ROS_BPN}* ${D}/usr/lib/python3.9/site-packages/
    rm -r ${D}/home
}