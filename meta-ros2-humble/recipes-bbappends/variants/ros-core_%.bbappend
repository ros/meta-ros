# Copyright (c) 2019 LG Electronics, Inc.

# Need this to launch anything ROS.
ROS_EXEC_DEPENDS += " \
    ros-workspace \
    rosidl-generator-cpp \
    rosidl-typesupport-c \
"

# core-* OE images do not support development.
ROS_EXEC_DEPENDS:remove = "ament-cmake"
ROS_EXEC_DEPENDS:remove = "ament-cmake-auto"
ROS_EXEC_DEPENDS:remove = "ament-cmake-gmock"
ROS_EXEC_DEPENDS:remove = "ament-cmake-gtest"
ROS_EXEC_DEPENDS:remove = "ament-cmake-pytest"
ROS_EXEC_DEPENDS:remove = "ament-cmake-ros"
ROS_EXEC_DEPENDS:remove = "ament-index-cpp"
ROS_EXEC_DEPENDS:remove = "ament-index-python"
ROS_EXEC_DEPENDS:remove = "ament-lint-auto"
ROS_EXEC_DEPENDS:remove = "ament-lint-common"
ROS_EXEC_DEPENDS:remove = "launch-testing-ament-cmake"
ROS_EXEC_DEPENDS:remove = "rosidl-default-generators"
