# Copyright (c) 2019-2020 LG Electronics, Inc.

# The cmake subdirectory isn't under datadir/ROS_BPN. In fact, there are two.
FILES_${PN}-dev_prepend = " \
    ${ros_libdir}/BehaviorTreeV3/cmake \
"

ROS_BUILD_DEPENDS += "cppzmq"
