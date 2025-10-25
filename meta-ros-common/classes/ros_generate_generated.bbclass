# Inherited by every recipe that ros-generate generates.
#
# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2025 Wind River Systems, Inc.

ROS_GENERATE_GENERATED = "1"

# If ros-generate found this BPN listed as a build tool, extend the recipe to build BPN-native and BPN-nativesdk.
BBCLASSEXTEND:append = "${@bb.utils.contains('ROS_GENERATE_GENERATED_BUILDTOOLS', '${BPN}-native', ' native nativesdk', '', d)}"

inherit ros_component
