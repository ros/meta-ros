# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Python access for event_camera_msgs."
AUTHOR = "Bernd Pfrommer <bernd.pfrommer@gmail.com>"
ROS_AUTHOR = "Bernd Pfrommer <bernd.pfrommer@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "event_camera_py"
ROS_BPN = "event_camera_py"

ROS_BUILD_DEPENDS = " \
    event-camera-codecs \
    event-camera-msgs \
    pybind11-vendor \
    ros-environment \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-native \
    ament-cmake-python-native \
    ament-cmake-ros-native \
    python-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    event-camera-codecs \
    event-camera-msgs \
    pybind11-vendor \
    ros-environment \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    event-camera-codecs \
    event-camera-msgs \
    pybind11-vendor \
    ros-environment \
    rpyutils \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-clang-format \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    python3-numpy \
    rclpy \
    rosbag2-py \
    rosbag2-storage-default-plugins \
    rosidl-runtime-py \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/event_camera_py-release/archive/release/humble/event_camera_py/1.1.6-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/event_camera_py"
SRC_URI = "git://github.com/ros2-gbp/event_camera_py-release;${ROS_BRANCH};protocol=https"
SRCREV = "8aa63cc5c82279a2acd2f02c6759cef1e63ea273"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
