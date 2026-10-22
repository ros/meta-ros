# Copyright (c) 2021 LG Electronics, Inc.

inherit python3targetconfig

ROS_BUILDTOOL_DEPENDS += "\
    python3-numpy-native \
    rosidl-adapter \
"

INSANE_SKIP:${PN} += "already-stripped"
