# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    Vendor package for: sdformat14 14.8.0\
    \
    SDFormat is an XML file format that describes environments, objects, and robots\
    in a manner suitable for robotic applications\
"
AUTHOR = "Addisu Z. Taddese <addisuzt@intrinsic.ai>"
HOMEPAGE = "https://github.com/gazebosim/sdformat"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=21;endline=21;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "sdformat_vendor"
ROS_BPN = "sdformat_vendor"

ROS_BUILD_DEPENDS = "\
    libtinyxml2\
    urdfdom\
    python3-pybind11\
    gz-cmake-vendor\
    gz-math-vendor\
    gz-utils-vendor\
    gz-tools-vendor\
    sdformat14\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-core-native\
    ament-cmake-test-native\
    ament-cmake-vendor-package-native\
    cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    gz-cmake-vendor\
    gz-math-vendor\
    gz-utils-vendor\
    gz-tools-vendor\
    sdformat14\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    libtinyxml2\
    urdfdom\
    python3-pybind11\
    gz-cmake-vendor\
    gz-math-vendor\
    gz-utils-vendor\
    gz-tools-vendor\
    sdformat14\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    libxml2\
    python3-psutil\
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

ROS_BRANCH ?= "branch=release/jazzy/sdformat_vendor"
SRC_URI = "git://github.com/ros2-gbp/sdformat_vendor-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "73a61ba0ebb7c7178a2218dfeb28354ec3fbc8b4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
