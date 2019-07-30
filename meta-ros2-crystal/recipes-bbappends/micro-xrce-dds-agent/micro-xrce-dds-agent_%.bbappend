# Copyright (c) 2019 LG Electronics, Inc.

# This component doesn't use datadir/ROS_BPN
ROS_DATADIR = "${datadir}/microxrcedds_agent"

FILES_${PN}-dev_prepend = " \
    ${ROS_DATADIR}/cmake \
"

FILES_${PN}-doc_prepend = " \
    ${ROS_DATADIR}/LICENSE \
"

inherit ros-insane
