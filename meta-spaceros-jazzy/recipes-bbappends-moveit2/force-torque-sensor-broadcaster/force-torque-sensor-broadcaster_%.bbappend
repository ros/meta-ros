# Copyright (c) 2022-2024 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "\
    tf2\
    tf2-geometry-msgs\
    tf2-ros\
"

ROS_EXPORT_DEPENDS += "\
    tf2\
    tf2-geometry-msgs\
    tf2-ros\
"

ROS_EXEC_DEPENDS += "\
    tf2\
    tf2-geometry-msgs\
    tf2-ros\
"

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
    python3-pyyaml-native \
"
