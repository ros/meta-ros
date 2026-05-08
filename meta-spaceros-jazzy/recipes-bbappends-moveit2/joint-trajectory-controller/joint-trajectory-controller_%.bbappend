# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += "\
    generate-parameter-library-py-native \
"

# tl-expected does not have a runtime package
ROS_EXEC_DEPENDS:remove = "tl-expected"
