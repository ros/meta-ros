# Copyright (c) 2019 LG Electronics, Inc.

# ROS_DISTRO-cache.yaml has <build_type> as ament_cmake -- huh?
ROS_BUILD_TYPE = "cmake"

inherit python3native

FILES_${PN}_prepend = " \
    ${datadir}/ament_index \
"
