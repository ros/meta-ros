# Copyright (c) 2019 LG Electronics, Inc.

# The cmake subdirectory isn't under datadir/ROS_BPN.
FILES_${PN}-dev_prepend = " \
    ${libdir}/BehaviorTree/cmake \
"
