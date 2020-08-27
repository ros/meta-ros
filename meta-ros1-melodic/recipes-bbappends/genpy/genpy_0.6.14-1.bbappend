# Copyright (c) 2020 LG Electronics, Inc.

# Needed for genpy to work without native recipes respecting RDEPENDS in oe-core/thud without
# http://git.openembedded.org/openembedded-core/commit/?id=c62520b63284927e177831c351fafa4d2768cb1f
ROS_BUILD_DEPENDS += "${PYTHON_PN}-pyyaml"
