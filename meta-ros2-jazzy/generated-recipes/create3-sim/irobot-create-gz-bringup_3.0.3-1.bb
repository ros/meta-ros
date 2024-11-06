# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Provides launch and configuration scripts for a Ignition simulated iRobot(R) Create(R) 3 Educational Robot."
AUTHOR = "rkreinin <rkreinin@clearpathrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "create3_sim"
ROS_BPN = "irobot_create_gz_bringup"

ROS_BUILD_DEPENDS = " \
    ros-gz-interfaces \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ros-gz-interfaces \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    gz-ros2-control \
    irobot-create-common-bringup \
    irobot-create-description \
    irobot-create-gz-toolbox \
    irobot-create-msgs \
    ros-gz-bridge \
    ros-gz-interfaces \
    ros-gz-sim \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-flake8 \
    ament-cmake-lint-cmake \
    ament-cmake-pep257 \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
    ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/create3_sim-release/archive/release/jazzy/irobot_create_gz_bringup/3.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/irobot_create_gz_bringup"
SRC_URI = "git://github.com/ros2-gbp/create3_sim-release;${ROS_BRANCH};protocol=https"
SRCREV = "7f358bd89dc345d57cbadeec7e250a4a06df8e55"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
