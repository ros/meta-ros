# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

# package.xml declares "BSD" but the package has no license text. Other
# packages in the same upstream repository carry BSD-3-Clause headers.
LICENSE = "BSD-3-Clause"
