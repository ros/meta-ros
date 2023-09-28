# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "CMake Functions and Modules for automating CMake"
AUTHOR = "Kevin Rösch <kevin.roesch@kit.edu>"
ROS_AUTHOR = "Fabian Poggenhans <fabian.poggenhans@kit.edu>"
HOMEPAGE = "http://wiki.ros.org/mrt_cmake_modules"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrt_cmake_modules"
ROS_BPN = "mrt_cmake_modules"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-core-native \
    python3-catkin-pkg-native \
    python3-pyyaml-native \
    python3-rospkg-native \
    python3-setuptools-native \
    ros-environment-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    gtest-vendor-native \
    lcov-native \
    python3-catkin-pkg-native \
    python3-pyyaml-native \
    python3-rospkg-native \
    python3-setuptools-native \
    ros-environment-native \
"

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/KIT-MRT/mrt_cmake_modules-release/archive/release/foxy/mrt_cmake_modules/1.0.8-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/mrt_cmake_modules"
SRC_URI = "git://github.com/KIT-MRT/mrt_cmake_modules-release;${ROS_BRANCH};protocol=https"
SRCREV = "9a6fca69ada5a1fb57ba99f7228306498f065666"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
