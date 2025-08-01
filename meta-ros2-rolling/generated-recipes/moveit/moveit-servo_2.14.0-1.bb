# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Provides real-time manipulator Cartesian and joint servoing."
AUTHOR = "Blake Anderson <blakeanderson@utexas.edu>"
ROS_AUTHOR = "Brian O'Neil"
HOMEPAGE = "https://moveit.github.io/moveit_tutorials"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "moveit"
ROS_BPN = "moveit_servo"

ROS_BUILD_DEPENDS = " \
    control-msgs \
    generate-parameter-library \
    geometry-msgs \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    pluginlib \
    realtime-tools \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    control-msgs \
    generate-parameter-library \
    geometry-msgs \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    pluginlib \
    realtime-tools \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-msgs \
    controller-manager \
    generate-parameter-library \
    geometry-msgs \
    joint-state-broadcaster \
    joint-trajectory-controller \
    joy \
    launch-param-builder \
    moveit-common \
    moveit-configs-utils \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    moveit-ros-planning-interface \
    moveit-ros-visualization \
    pluginlib \
    realtime-tools \
    robot-state-publisher \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-eigen \
    tf2-ros \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    moveit-resources-panda-moveit-config \
    ros-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/moveit2-release/archive/release/rolling/moveit_servo/2.14.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/moveit_servo"
SRC_URI = "git://github.com/ros2-gbp/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "662b3a228063223b73352cb10c8a1a76ab2998b1"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
