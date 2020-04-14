# Copyright (c) 2020 LG Electronics, Inc.

# Needed for rosidl to work without native recipes respecting RDEPENDS in oe-core/thud without
# http://git.openembedded.org/openembedded-core/commit/?id=c62520b63284927e177831c351fafa4d2768cb1f
DEPENDS += "${ROS_EXEC_DEPENDS}"
