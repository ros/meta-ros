# Copyright (c) 2021 LG Electronics, Inc.

# Doesn't seem to be really mandatory
DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch launch-testing-ament-cmake', '', d)}"
RDEPENDS:${PN}:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch launch-testing-ament-cmake', '', d)}"
