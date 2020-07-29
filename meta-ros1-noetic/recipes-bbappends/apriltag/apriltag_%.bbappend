# Copyright (c) 2019-2020 LG Electronics, Inc.

inherit ros_insane_dev_so

# release/melodic/apriltag/3.1.2-1 is no longer in release/melodic/apriltag branch
#
# Reported in: https://github.com/AprilRobotics/apriltag-release/issues/1
#
# WARNING: apriltag-3.1.2-1-r0 do_fetch: Failed to fetch URL git://github.com/AprilRobotics/apriltag-release;branch=release/melodic/apriltag;protocol=https, attempting MIRRORS if available
# ERROR: apriltag-3.1.2-1-r0 do_fetch: Fetcher failure: Unable to find revision 17a996455fc2cad7546e716fc45fe10fb92074c5 in branch release/melodic/apriltag even from upstream
# ERROR: apriltag-3.1.2-1-r0 do_fetch: Fetcher failure for URL: 'git://github.com/AprilRobotics/apriltag-release;branch=release/melodic/apriltag;protocol=https'. Unable to fetch URL from any source.
ROS_BRANCH = "nobranch=1"
