# Copyright (c) 2020 LG Electronics, Inc.

# There is typo in rosdep/base.yaml:  openembedded: [libjpeq-turbo@openembedded-core]
ROS_BUILD_DEPENDS:remove = "libjpeq-turbo"
ROS_EXPORT_DEPENDS:remove = "libjpeq-turbo"
ROS_EXEC_DEPENDS:remove = "libjpeq-turbo"

ROS_BUILD_DEPENDS:append = " libjpeg-turbo"
ROS_EXPORT_DEPENDS:append = " libjpeg-turbo"
ROS_EXEC_DEPENDS:append = " libjpeg-turbo"

ROS_BUILDTOOL_DEPENDS:remove = "yaml-cpp-native"
