# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Vendor package for: gz-math7 7.5.2\
    \
    Gazebo Math : Math classes and functions for robot applications\
"
AUTHOR = "Addisu Z. Taddese <addisuzt@intrinsic.ai>"
HOMEPAGE = "https://github.com/gazebosim/gz-math"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "gz_math_vendor"
ROS_BPN = "gz_math_vendor"

ROS_BUILD_DEPENDS = "\
    python3-pybind11\
    libeigen\
    gz-cmake-vendor\
    gz-utils-vendor\
    gz-math7\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-core-native\
    ament-cmake-test-native\
    ament-cmake-vendor-package-native\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    gz-cmake-vendor\
    gz-utils-vendor\
    gz-math7\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    libeigen\
    gz-cmake-vendor\
    gz-utils-vendor\
    gz-math7\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    python3-pytest\
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

ROS_BRANCH ?= "branch=release/jazzy/gz_math_vendor"
SRC_URI = "git://github.com/ros2-gbp/gz_math_vendor-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "cc7033ad37284a723cdb90df65e821ab3bfd2a50"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
