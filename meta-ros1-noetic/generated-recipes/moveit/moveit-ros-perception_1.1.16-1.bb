# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Components of MoveIt connecting to perception"
AUTHOR = "Michael Ferguson <mferguson@fetchrobotics.com>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit"
ROS_BPN = "moveit_ros_perception"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    libeigen \
    mesa \
    message-filters \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    nodelet \
    object-recognition-msgs \
    openmp \
    pluginlib \
    rosconsole \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    mesa \
    message-filters \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    nodelet \
    object-recognition-msgs \
    openmp \
    pluginlib \
    rosconsole \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    freeglut \
    glew \
    image-transport \
    mesa \
    message-filters \
    moveit-core \
    moveit-msgs \
    moveit-ros-occupancy-map-monitor \
    moveit-ros-planning \
    nodelet \
    object-recognition-msgs \
    openmp \
    pluginlib \
    rosconsole \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/moveit-release/archive/release/noetic/moveit_ros_perception/1.1.16-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/moveit_ros_perception"
SRC_URI = "git://github.com/ros-gbp/moveit-release;${ROS_BRANCH};protocol=https"
SRCREV = "f24e3d27c9d1e7e2eb0317410fb3c22080cece26"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
