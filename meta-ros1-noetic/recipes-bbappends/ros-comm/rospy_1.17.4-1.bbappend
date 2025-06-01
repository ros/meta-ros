# Copyright (c) 2020 LG Electronics, Inc.

# In new version the dependencies were removed from ROS_EXPORT_DEPENDS
# and are only in ROS_EXEC_DEPENDS.
# https://github.com/ros-gbp/ros_comm-release/compare/release/melodic/rospy/1.14.3-0...release/melodic/rospy/1.14.5-1#diff-34ae68f4adad56c25c5bc05dcb64794eL30
# Needed for rospy to work without native recipes respecting RDEPENDS in oe-core/thud without
# http://git.openembedded.org/openembedded-core/commit/?id=c62520b63284927e177831c351fafa4d2768cb1f
ROS_BUILD_DEPENDS += "${ROS_EXEC_DEPENDS}"
