# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Components of MoveIt connecting to perception"
AUTHOR = "Henning Kayser <henningkayser@picknik.ai>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=4633480cdd27d7906aaf3ef4b72014b2"

ROS_CN = "moveit"
ROS_BPN = "moveit_ros_perception"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libomp-dev} \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    libeigen \
    mesa \
    message-filters \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    object-recognition-msgs \
    pluginlib \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libomp-dev} \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    mesa \
    message-filters \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    object-recognition-msgs \
    pluginlib \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-libomp-dev} \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    mesa \
    message-filters \
    moveit-common \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    object-recognition-msgs \
    pluginlib \
    rclcpp \
    sensor-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/moveit2-release/archive/release/jazzy/moveit_ros_perception/2.10.0-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/moveit_ros_perception"
SRC_URI = "git://github.com/ros2-gbp/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "5a4fd053525dfaaa338cf73cb2d1956f089d83f4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
