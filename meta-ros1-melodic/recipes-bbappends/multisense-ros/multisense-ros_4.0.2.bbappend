# Copyright (c) 2020 LG Electronics, Inc.

# There is typo in rosdep/base.yaml:  openembedded: [libjpeq-turbo@openembedded-core]
ROS_BUILD_DEPENDS_remove = "libjpeq-turbo"
ROS_EXPORT_DEPENDS_remove = "libjpeq-turbo"
ROS_EXEC_DEPENDS_remove = "libjpeq-turbo"

ROS_BUILD_DEPENDS_append = " libjpeg-turbo"
ROS_EXPORT_DEPENDS_append = " libjpeg-turbo"
ROS_EXEC_DEPENDS_append = " libjpeg-turbo"

# Depends on gstreamer1.0-* with this restriction:
inherit distro_features_check
REQUIRED_DISTRO_FEATURES_append_rpi = " opengl"
