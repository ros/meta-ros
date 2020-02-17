# Copyright (c) 2020 LG Electronics, Inc.

# There is typo in rosdep/base.yaml:  openembedded: [libjpeq-turbo@openembedded-core]
ROS_BUILD_DEPENDS_remove = "libjpeq-turbo"
ROS_EXPORT_DEPENDS_remove = "libjpeq-turbo"
ROS_EXEC_DEPENDS_remove = "libjpeq-turbo"

ROS_BUILD_DEPENDS_append = " libjpeg-turbo"
ROS_EXPORT_DEPENDS_append = " libjpeg-turbo"
ROS_EXEC_DEPENDS_append = " libjpeg-turbo"

PNBLACKLIST[multisense-ros] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'vc4graphics-without-opengl', 'Depends on gstreamer1.0-plugins-base which is not available for raspberrypi MACHINEs with vc4graphics in MACHINE_FEATURES, but without opengl in DISTRO_FEATURES', '', d)}"

ROS_BUILDTOOL_DEPENDS_remove = "yaml-cpp-native"
