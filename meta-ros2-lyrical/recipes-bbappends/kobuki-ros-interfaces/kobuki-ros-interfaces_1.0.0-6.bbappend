# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-generators-native \
    rosidl-default-runtime-native \
"

# package.xml declares "BSD" but neither the package nor its upstream
# repository has any license text. BSD-3-Clause is assumed as the usual
# meaning of "BSD" in ROS packages.
LICENSE = "BSD-3-Clause"
