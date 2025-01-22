# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "A ROS 2 middleware implementation using zenoh-cpp"
AUTHOR = "Yadunund <yadunund@openrobotics.org>"
ROS_AUTHOR = "Chris Lalancette <clalancette@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0 & MIT & BSD"
LICENSE = "Apache-2.0 & MIT & BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmw_zenoh"
ROS_BPN = "rmw_zenoh_cpp"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    fastcdr \
    rcpputils \
    rcutils \
    rmw \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    zenoh-cpp-vendor \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    fastcdr \
    rcpputils \
    rcutils \
    rmw \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    zenoh-cpp-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    fastcdr \
    rcpputils \
    rcutils \
    rmw \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
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

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmw_zenoh-release/archive/release/jazzy/rmw_zenoh_cpp/0.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/rmw_zenoh_cpp"
SRC_URI = "git://github.com/ros2-gbp/rmw_zenoh-release;${ROS_BRANCH};protocol=https"
SRCREV = "66959a9b931f1fc7161b9b3e182c482af25616e6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
