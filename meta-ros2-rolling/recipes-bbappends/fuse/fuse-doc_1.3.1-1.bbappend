LICENSE = "BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += "\
    ament-cmake-pytest \
    ament-cmake-gmock-native \
"

ROS_BUILDTOOL_DEPENDS:append = " \
    ament-cmake-ros-core-native \
"
