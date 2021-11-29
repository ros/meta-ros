# Inherited by every recipe that superflore generates.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_SUPERFLORE_GENERATED = "1"

# If superflore found this BPN listed as a build tool, extend the recipe to build BPN-native and BPN-nativesdk.
BBCLASSEXTEND:append = "${@bb.utils.contains('ROS_SUPERFLORE_GENERATED_BUILDTOOLS', '${BPN}-native', ' native nativesdk', '', d)}"

inherit ros_component
