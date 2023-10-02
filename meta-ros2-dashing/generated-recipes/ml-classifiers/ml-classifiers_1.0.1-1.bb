# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "ml_classifiers"
AUTHOR = "AutonomouStuff Software Development Team <software@autonomoustuff.com>"
ROS_AUTHOR = "Scott Niekum <sniekum@cs.utexas.edu>"
HOMEPAGE = "http://wiki.ros.org/ml_classifiers"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ml_classifiers"
ROS_BPN = "ml_classifiers"

ROS_BUILD_DEPENDS = " \
    libeigen \
    pluginlib \
    rclcpp \
    rosidl-default-generators \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ros-environment-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    pluginlib \
    rclcpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    pluginlib \
    rclcpp \
    rosidl-default-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-copyright \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-lint-cmake \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
    ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/astuff/ml_classifiers-release/archive/release/dashing/ml_classifiers/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/ml_classifiers"
SRC_URI = "git://github.com/astuff/ml_classifiers-release;${ROS_BRANCH};protocol=https"
SRCREV = "ce4914237bcb70f1f3d0adb350adff15aa506ad4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
