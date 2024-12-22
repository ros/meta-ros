# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Vendor package for: gz-math7 7.5.0      Gazebo Math : Math classes and functions for robot applications"
AUTHOR = "Addisu Z. Taddese <addisuzt@intrinsic.ai>"
HOMEPAGE = "https://github.com/gazebosim/gz-math"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "gz_math_vendor"
ROS_BPN = "gz_math_vendor"

ROS_BUILD_DEPENDS = " \
    gz-cmake-vendor \
    gz-utils-vendor \
    libeigen \
    python3-pybind11 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-core-native \
    ament-cmake-test-native \
    ament-cmake-vendor-package-native \
"

ROS_EXPORT_DEPENDS = " \
    gz-cmake-vendor \
    gz-utils-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gz-cmake-vendor \
    gz-utils-vendor \
    libeigen \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-copyright \
    ament-cmake-lint-cmake \
    ament-cmake-xmllint \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/gz_math_vendor-release/archive/release/rolling/gz_math_vendor/0.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/gz_math_vendor"
SRC_URI = "git://github.com/ros2-gbp/gz_math_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "4840f657d7752dff33b3d624cf54cb175e51dfe7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
