# Copyright (c) 2019-2020 LG Electronics, Inc.

# The cmake subdirectory isn't under datadir/ROS_BPN.
FILES:${PN}-dev:prepend = " \
    ${ros_libdir}/BehaviorTree/cmake \
"

ROS_BUILD_DEPENDS += "cppzmq"
