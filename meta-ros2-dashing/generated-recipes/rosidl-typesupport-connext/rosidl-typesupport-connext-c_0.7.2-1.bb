# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "Generate the C interfaces for RTI Connext."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosidl_typesupport_connext"
ROS_BPN = "rosidl_typesupport_connext_c"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    connext-cmake-module-native \
    rosidl-cmake-native \
    rosidl-generator-c-native \
    rosidl-typesupport-connext-cpp-native \
"

ROS_EXPORT_DEPENDS = " \
    rmw \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-cmake-native \
    connext-cmake-module-native \
    rcutils-native \
    rosidl-cmake-native \
    rosidl-generator-c-native \
    rosidl-generator-dds-idl-native \
    rosidl-typesupport-connext-cpp-native \
"

ROS_EXEC_DEPENDS = " \
    rosidl-parser \
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

# matches with: https://github.com/ros2-gbp/rosidl_typesupport_connext-release/archive/release/dashing/rosidl_typesupport_connext_c/0.7.2-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/rosidl_typesupport_connext_c"
SRC_URI = "git://github.com/ros2-gbp/rosidl_typesupport_connext-release;${ROS_BRANCH};protocol=https"
SRCREV = "3038a05f56a772e0c1df63f3fd7b43f0882b114d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
