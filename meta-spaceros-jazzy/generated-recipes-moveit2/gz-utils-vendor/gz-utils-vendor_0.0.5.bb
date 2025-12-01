# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Vendor package for: gz-utils2 2.2.1\
    \
    Gazebo Utils : Classes and functions for robot applications\
"
AUTHOR = "Addisu Z. Taddese <addisuzt@intrinsic.ai>"
HOMEPAGE = "https://github.com/gazebosim/gz-utils"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "gz_utils_vendor"
ROS_BPN = "gz_utils_vendor"

ROS_BUILD_DEPENDS = "\
    gz-cmake-vendor\
    gz-utils2\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-core-native\
    ament-cmake-test-native\
    ament-cmake-vendor-package-native\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    gz-cmake-vendor\
    gz-utils2\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    gz-cmake-vendor\
    gz-utils2\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-copyright\
    ament-cmake-lint-cmake\
    ament-cmake-xmllint\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/gz_utils_vendor"
SRC_URI = "git://github.com/ros2-gbp/gz_utils_vendor-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "703bec3b307c5820d6b866a9953f55a209b5cea9"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
