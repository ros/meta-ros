# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "Any tools relating to mathematical geometry.      Primarily featuring polynomials and interpolations."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/ecl_geometry"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ecl_core"
ROS_BPN = "ecl_geometry"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-config \
    ecl-containers \
    ecl-exceptions \
    ecl-formatters \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
    ecl-mpl \
    ecl-type-traits \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-build \
    ecl-config \
    ecl-containers \
    ecl-exceptions \
    ecl-formatters \
    ecl-license \
    ecl-linear-algebra \
    ecl-math \
    ecl-mpl \
    ecl-type-traits \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yujinrobot-release/ecl_core-release/archive/release/foxy/ecl_geometry/1.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/ecl_geometry"
SRC_URI = "git://github.com/yujinrobot-release/ecl_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "c783275122da250aa8d0e0df170fd65e53b0a6e3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
