# Copyright (c) 2019 LG Electronics, Inc.

# This is the tree under which CMakeLists.txt installs the files. Assume it's been done for a good reason.
ROS_PREFIX = "${prefix}/opt/${ROS_BPN}"

SYSROOT_DIRS_append = " ${ROS_PREFIX}"

FILES_${PN}_prepend = "${ROS_PREFIX}/lib/libyaml-cpp.so* "

FILES_${PN}-dev_prepend = " \
    ${ROS_PREFIX}/include \
    ${ROS_PREFIX}/lib/cmake \
    ${ROS_PREFIX}/lib/pkgconfig \
"

INSANE_SKIP_${PN} = "dev-so libdir"
