# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Vendor package for: gz-tools2 2.0.3\
    \
    Gazebo Tools: Entrypoint to Gazebo's command line interface\
"
AUTHOR = "Addisu Z. Taddese <addisuzt@intrinsic.ai>"
HOMEPAGE = "https://github.com/gazebosim/gz-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "gz_tools_vendor"
ROS_BPN = "gz_tools_vendor"

ROS_BUILD_DEPENDS = "\
    gz-cmake-vendor\
    gz-tools2\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-core-native\
    ament-cmake-test-native\
    ament-cmake-vendor-package-native\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    gz-cmake-vendor\
    gz-tools2\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    ruby\
    gz-cmake-vendor\
    gz-tools2\
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

ROS_BRANCH ?= "branch=release/jazzy/gz_tools_vendor"
SRC_URI = "git://github.com/ros2-gbp/gz_tools_vendor-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "54d44ab9a6515c5368c0b9ac04a63e7a81cb56c9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
