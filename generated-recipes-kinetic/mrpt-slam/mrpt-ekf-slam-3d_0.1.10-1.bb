# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "This package is a wrapper for the implementation of EKF-based SLAM with range-bearing sensors, odometry, a full 6D robot pose, and 3D landmarks."
AUTHOR = "Jose Luis <jlblanco@ual.es>"
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
    mrpt-bridge \
    mrpt1 \
    nav-msgs \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    mrpt-bridge \
    mrpt1 \
    nav-msgs \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    mrpt-bridge \
    mrpt-rawlog \
    mrpt1 \
    nav-msgs \
    roscpp \
    roslaunch \
    roslib \
    rviz \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/mrpt-ros-pkg-release/mrpt_slam-release/archive/release/kinetic/mrpt_ekf_slam_3d/0.1.10-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2d193e336319beb66bfdea4c92916412"
SRC_URI[sha256sum] = "ec92ee4e34186f8ee4d9aedfa094136fa29acad77ce6cf26be665167d13ad980"
S = "${WORKDIR}/mrpt_slam-release-release-kinetic-mrpt_ekf_slam_3d-0.1.10-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('mrpt-slam', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('mrpt-slam', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mrpt-slam/mrpt-slam_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mrpt-slam/mrpt-slam-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mrpt-slam/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/mrpt-slam/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
