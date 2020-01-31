# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "Implement the ROS middleware interface using ADLINK OpenSplice static code generation in C++."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmw_opensplice"
ROS_BPN = "rmw_opensplice_cpp"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libopensplice69} \
    rcpputils \
    rcutils \
    rmw \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-dds-idl \
    rosidl-typesupport-opensplice-c \
    rosidl-typesupport-opensplice-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    opensplice-cmake-module-native \
    rosidl-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libopensplice69} \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-typesupport-opensplice-c \
    rosidl-typesupport-opensplice-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-cmake-native \
    opensplice-cmake-module-native \
    rosidl-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    rmw \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmw_opensplice-release/archive/release/eloquent/rmw_opensplice_cpp/0.8.1-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/rmw_opensplice_cpp"
SRC_URI = "git://github.com/ros2-gbp/rmw_opensplice-release;${ROS_BRANCH};protocol=https"
SRCREV = "ca32ffd103e30fbb73b6862e1a6f98607a0f82fa"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
