# Copyright (c) 2019 LG Electronics, Inc.

# This component doesn't use datadir/ROS_BPN
ROS_DATADIR = "${datadir}/ros1_rosbag_storage"

FILES_${PN}_prepend = " \
    ${ROS_DATADIR}/package.xml \
"

FILES_${PN}-dev_prepend = " \
    ${ROS_DATADIR}/cmake \
"
