# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_insane_dev_so

# The cmake files aren't in their own "cmake" subdirectory.
FILES:${PN}-dev:prepend = " \
    ${datadir}/${ROS_BPN}/*.cmake \
"
