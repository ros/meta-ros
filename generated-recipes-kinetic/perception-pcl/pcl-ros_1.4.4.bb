# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "PCL (Point Cloud Library) ROS interface stack. PCL-ROS is the preferred   bridge for 3D applications involving n-D Point Clouds and 3D geometry   processing in ROS."
AUTHOR = "Paul Bovbel <paul@bovbel.com>"
ROS_AUTHOR = "Open Perception"
HOMEPAGE = "http://ros.org/wiki/perception_pcl"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "perception_pcl"
ROS_BPN = "pcl_ros"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    genmsg \
    libeigen \
    message-filters \
    nodelet \
    nodelet-topic-tools \
    pcl \
    pcl-conversions \
    pcl-msgs \
    pluginlib \
    rosbag \
    rosconsole \
    roscpp \
    roslib \
    sensor-msgs \
    std-msgs \
    tf \
    tf2-eigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    libeigen \
    message-filters \
    nodelet \
    nodelet-topic-tools \
    pcl \
    pcl-conversions \
    pcl-msgs \
    pluginlib \
    rosbag \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    tf2-eigen \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    libeigen \
    message-filters \
    nodelet \
    nodelet-topic-tools \
    pcl \
    pcl-conversions \
    pcl-msgs \
    pluginlib \
    rosbag \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    tf2-eigen \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/perception_pcl-release/archive/release/kinetic/pcl_ros/1.4.4-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2164088f02c653adcc2c71c2e6d197af"
SRC_URI[sha256sum] = "614de7441e08a0f488729eea2dbb47b0a249f0ad803b5fc550a795a9b3060578"
S = "${WORKDIR}/perception_pcl-release-release-kinetic-pcl_ros-1.4.4-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('perception-pcl', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('perception-pcl', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/perception-pcl/perception-pcl_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/perception-pcl/perception-pcl-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/perception-pcl/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/perception-pcl/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
