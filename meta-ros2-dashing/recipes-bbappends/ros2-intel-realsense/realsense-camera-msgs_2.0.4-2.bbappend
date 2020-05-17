# Copyright (c) 2020 LG Electronics, Inc.

# release/dashing/realsense_camera_msgs branch got removed recently
#
# Reported in: https://github.com/ros2-gbp/ros2_intel_realsense-release/issues/1
#
# WARNING: realsense-camera-msgs-2.0.4-2-r0 do_fetch: Failed to fetch URL git://github.com/ros2-gbp/ros2_intel_realsense-release;branch=release/dashing/realsense_camera_msgs;protocol=https, attempting MIRRORS if available
# ERROR: realsense-camera-msgs-2.0.4-2-r0 do_fetch: Fetcher failure: Unable to find revision bd258324c788596ccbdd38f476ad8fc06c2f4a5d in branch release/dashing/realsense_camera_msgs even from upstream
# ERROR: realsense-camera-msgs-2.0.4-2-r0 do_fetch: Fetcher failure for URL: 'git://github.com/ros2-gbp/ros2_intel_realsense-release;branch=release/dashing/realsense_camera_msgs;protocol=https'. Unable to fetch URL from any source.
ROS_BRANCH = "nobranch=1"
