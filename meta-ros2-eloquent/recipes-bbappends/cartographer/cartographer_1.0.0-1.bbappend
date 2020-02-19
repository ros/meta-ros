# Copyright (c) 2020 LG Electronics, Inc.

# needs native protobuf otherwise fails to find protoc resulting in do_compile failures:
# | /bin/sh: 1: Protobuf_PROTOC_EXECUTABLE-NOTFOUND: not found
ROS_BUILDTOOL_DEPENDS += " \
    protobuf-native \
"

