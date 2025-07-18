# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The new driver for Universal Robots UR3, UR5 and UR10 robots with CB3 controllers and the e-series."
AUTHOR = "Felix Exner <feex@universal-robots.com>"
ROS_AUTHOR = "Thomas Timm Andersen"
HOMEPAGE = "http://wiki.ros.org/ur_robot_driver"
SECTION = "devel"
LICENSE = "Apache-2.0 & BSD-2-Clause & Zlib"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_robot_driver"

ROS_BUILD_DEPENDS = " \
    actionlib \
    boost \
    control-msgs \
    controller-manager \
    controller-manager-msgs \
    geometry-msgs \
    hardware-interface \
    industrial-robot-status-interface \
    kdl-parser \
    pass-through-controllers \
    pluginlib \
    roscpp \
    scaled-joint-trajectory-controller \
    sensor-msgs \
    speed-scaling-interface \
    speed-scaling-state-controller \
    std-srvs \
    tf \
    tf2-geometry-msgs \
    tf2-msgs \
    trajectory-msgs \
    ur-client-library \
    ur-dashboard-msgs \
    ur-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    control-msgs \
    controller-manager \
    controller-manager-msgs \
    geometry-msgs \
    hardware-interface \
    kdl-parser \
    pass-through-controllers \
    pluginlib \
    roscpp \
    scaled-joint-trajectory-controller \
    sensor-msgs \
    speed-scaling-interface \
    speed-scaling-state-controller \
    std-srvs \
    tf \
    tf2-geometry-msgs \
    tf2-msgs \
    trajectory-msgs \
    ur-client-library \
    ur-dashboard-msgs \
    ur-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    cartesian-trajectory-controller \
    control-msgs \
    controller-manager \
    controller-manager-msgs \
    force-torque-sensor-controller \
    geometry-msgs \
    hardware-interface \
    industrial-robot-status-controller \
    joint-state-controller \
    joint-trajectory-controller \
    kdl-parser \
    pass-through-controllers \
    pluginlib \
    robot-state-publisher \
    roscpp \
    scaled-joint-trajectory-controller \
    sensor-msgs \
    socat \
    speed-scaling-interface \
    speed-scaling-state-controller \
    std-srvs \
    tf \
    tf2-geometry-msgs \
    tf2-msgs \
    trajectory-msgs \
    twist-controller \
    ur-client-library \
    ur-dashboard-msgs \
    ur-description \
    ur-msgs \
    velocity-controllers \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/UniversalRobots/Universal_Robots_ROS_Driver-release/archive/release/noetic/ur_robot_driver/2.4.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ur_robot_driver"
SRC_URI = "git://github.com/UniversalRobots/Universal_Robots_ROS_Driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "b488b9bda26b61bd6af4cad7a52a9e9c8f101e7c"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
