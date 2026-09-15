# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# Replace libexpected-dev with tl-expected
ROS_BUILD_DEPENDS:remove = "libexpected-dev"
ROS_EXEC_DEPENDS:remove = "libexpected-dev"
ROS_EXPORT_DEPENDS:remove = "libexpected-dev"

# tl-expected does not have a runtime package
ROS_EXEC_DEPENDS:remove = "tl-expected"
