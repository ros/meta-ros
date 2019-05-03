# Copyright (c) 2019 LG Electronics, Inc.

# The cmake subdirectory isn't under datadir/ROS_BPN. In fact, there are two.
FILES_${PN}-dev_prepend = " \
    ${libdir}/cmake/${ROS_BPN} \
    ${libdir}/BehaviorTree/cmake \
"
