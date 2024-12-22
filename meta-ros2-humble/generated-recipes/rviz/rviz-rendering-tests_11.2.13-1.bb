# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Example plugin for RViz - documents and tests RViz plugin development"
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "William Woodall <william@openrobotics.org>"
HOMEPAGE = "https://github.com/ros2/rviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz"
ROS_BPN = "rviz_rendering_tests"

ROS_BUILD_DEPENDS = " \
    qtbase \
    resource-retriever \
    rviz-rendering \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    resource-retriever \
    rviz-rendering \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    resource-retriever \
    rviz-rendering \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-lint-cmake \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
    ament-index-cpp \
    ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rviz-release/archive/release/humble/rviz_rendering_tests/11.2.13-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/rviz_rendering_tests"
SRC_URI = "git://github.com/ros2-gbp/rviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "dd6ca8882ee78e88352e63181f3245a1e4b2bb2d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
