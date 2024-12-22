# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package is a wrapper for the implementation of EKF-based SLAM with range-bearing sensors, odometry, a full 6D robot pose, and 3D landmarks."
AUTHOR = "Jose Luis Blanco-Claraco <joseluisblancoc@gmail.com>"
ROS_AUTHOR = "Jose Luis"
HOMEPAGE = "http://ros.org/wiki/mrpt_ekf_slam_3d"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mrpt_slam"
ROS_BPN = "mrpt_ekf_slam_3d"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    mrpt-libgui \
    mrpt-libros-bridge \
    mrpt-libslam \
    mrpt-msgs-bridge \
    nav-msgs \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    mrpt-libgui \
    mrpt-libros-bridge \
    mrpt-libslam \
    mrpt-msgs-bridge \
    nav-msgs \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    mrpt-libgui \
    mrpt-libros-bridge \
    mrpt-libslam \
    mrpt-msgs-bridge \
    mrpt-rawlog \
    nav-msgs \
    roscpp \
    roslaunch \
    roslib \
    rviz \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/mrpt-ros-pkg-release/mrpt_slam-release/archive/release/noetic/mrpt_ekf_slam_3d/0.1.19-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mrpt_ekf_slam_3d"
SRC_URI = "git://github.com/mrpt-ros-pkg-release/mrpt_slam-release;${ROS_BRANCH};protocol=https"
SRCREV = "7ef34e565f529c6585d3a500a467bccfc687a203"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
