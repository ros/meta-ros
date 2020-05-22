# Copyright (c) 2020 LG Electronics, Inc.

# release/eloquent/robot_state_publisher branch got removed recently
#
# Reported in: https://github.com/ros2-gbp/robot_state_publisher-release/issues/2
#
# WARNING: robot-state-publisher-2.3.1-1-r0 do_fetch: Failed to fetch URL git://github.com/ros2-gbp/robot_state_publisher-release;branch=release/eloquent/robot_state_publisher;protocol=https, attempting MIRRORS if available
# ERROR: robot-state-publisher-2.3.1-1-r0 do_fetch: Fetcher failure: Unable to find revision 35190030ec89fd194e866ac75e8cc053953919e3 in branch release/eloquent/robot_state_publisher even from upstream
# ERROR: robot-state-publisher-2.3.1-1-r0 do_fetch: Fetcher failure for URL: 'git://github.com/ros2-gbp/robot_state_publisher-release;branch=release/eloquent/robot_state_publisher;protocol=https'. Unable to fetch URL from any source.
ROS_BRANCH = "nobranch=1"
