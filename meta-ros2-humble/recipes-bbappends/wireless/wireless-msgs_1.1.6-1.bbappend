# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# package.xml declares "BSD" but the package has no license text. Other
# packages in the same upstream repository carry BSD-3-Clause headers.
LICENSE = "BSD-3-Clause"
