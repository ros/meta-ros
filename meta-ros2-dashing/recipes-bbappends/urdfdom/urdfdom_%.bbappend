# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_insane_dev_so

# The cmake subdirectory is under libdir/ROS_BPN instead of datadir/ROS_BPN.
FILES:${PN}-dev:prepend = " \
    ${libdir}/${ROS_BPN}/cmake \
"
