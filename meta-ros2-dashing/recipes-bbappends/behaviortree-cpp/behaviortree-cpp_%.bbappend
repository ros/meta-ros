# Copyright (c) 2019 LG Electronics, Inc.

# The cmake subdirectory isn't under datadir/ROS_BPN.
FILES:${PN}-dev:prepend = " \
    ${libdir}/BehaviorTree/cmake \
"
