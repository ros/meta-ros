# Copyright (c) 2020 LG Electronics, Inc.

# Doesn't seem to be really mandatory
DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch launch-testing-ament-cmake', '', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'launch', 'launch launch-testing-ament-cmake', '', d)}"
