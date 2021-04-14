# Copyright (c) 2020 LG Electronics, Inc.

# This doesn't seem to be needed and would require google-benchmark and google-benchmark-vendor to have native BBCLASSEXTEND as well
ROS_BUILDTOOL_EXPORT_DEPENDS_remove = " \
    ament-cmake-google-benchmark-native \
"
