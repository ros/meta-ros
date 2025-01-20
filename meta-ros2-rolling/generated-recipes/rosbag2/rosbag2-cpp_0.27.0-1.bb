# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "C++ ROSBag2 client library"
AUTHOR = "Michael Orlov <michael.orlov@apex.ai>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rosbag2"
ROS_BPN = "rosbag2_cpp"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    pluginlib \
    rclcpp \
    rcpputils \
    rcutils \
    rmw \
    rmw-implementation \
    rosbag2-storage \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-typesupport-cpp \
    rosidl-typesupport-introspection-cpp \
    shared-queues-vendor \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    pluginlib \
    rclcpp \
    rcpputils \
    rcutils \
    rmw \
    rmw-implementation \
    rosbag2-storage \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-typesupport-cpp \
    rosidl-typesupport-introspection-cpp \
    shared-queues-vendor \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    pluginlib \
    rclcpp \
    rcpputils \
    rcutils \
    rmw \
    rmw-implementation \
    rosbag2-storage \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-typesupport-cpp \
    rosidl-typesupport-introspection-cpp \
    shared-queues-vendor \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-lint-auto \
    ament-lint-common \
    rosbag2-storage-default-plugins \
    rosbag2-test-common \
    rosbag2-test-msgdefs \
    test-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rosbag2-release/archive/release/rolling/rosbag2_cpp/0.27.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rosbag2_cpp"
SRC_URI = "git://github.com/ros2-gbp/rosbag2-release;${ROS_BRANCH};protocol=https"
SRCREV = "c1737a76eede353e2bc719896253db4862eb0ebb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}