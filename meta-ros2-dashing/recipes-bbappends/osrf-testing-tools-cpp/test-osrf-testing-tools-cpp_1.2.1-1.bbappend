# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += "osrf-testing-tools-cpp"

# Fetched tarballs have incorrect top level directory.
S = "${WORKDIR}/osrf_testing_tools_cpp-release-release-${ROS_DISTRO}-${ROS_BPN}-${PV}"
