# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Library which provides the 3D rendering functionality in rviz."
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "https://github.com/ros2/rviz/blob/ros2/README.md"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz"
ROS_BPN = "rviz_rendering"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    libeigen \
    qtbase \
    resource-retriever \
    rviz-assimp-vendor \
    rviz-ogre-vendor \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    eigen3-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    qtbase \
    rviz-ogre-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    qtbase \
    resource-retriever \
    rviz-assimp-vendor \
    rviz-ogre-vendor \
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
    ament-lint-auto \
    rviz-assimp-vendor \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rviz-release/archive/release/galactic/rviz_rendering/8.5.0-3.tar.gz
ROS_BRANCH ?= "branch=release/galactic/rviz_rendering"
SRC_URI = "git://github.com/ros2-gbp/rviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "61b4c5d82c26c25a2bf4f413c6a845d68ae4c9e2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
