# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>       Python implementation of the driver package for the Naoqi robot, providing access to walking commands,       joint angles, and sensor data (odometry, IMU, ...). The       most-current version is compatible with the Nao API version 1.12 or newer,       connecting to a real or simulated Nao by wrapping Aldebaran Robotics'       NaoQI API in Python. This requires the &quot;lib&quot; directory of the Aldebaran       Python SDK to be in your PYTHONPATH environment variable.        Note that cameras drivers are provided in a separate package (naoqi_sensors_py).     </p>"
AUTHOR = "Severin Lemaignan <severin.lemaignan@epfl.ch>"
ROS_AUTHOR = "Armin Hornung"
HOMEPAGE = "http://ros.org/wiki/naoqi_driver"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "naoqi_bridge"
ROS_BPN = "naoqi_driver_py"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    dynamic-reconfigure \
    geometry-msgs \
    humanoid-nav-msgs \
    naoqi-bridge-msgs \
    nav-msgs \
    roslaunch \
    rospy \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    dynamic-reconfigure \
    geometry-msgs \
    humanoid-nav-msgs \
    naoqi-bridge-msgs \
    nav-msgs \
    roslaunch \
    rospy \
    sensor-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-naoqi/naoqi_bridge-release/archive/release/kinetic/naoqi_driver_py/0.5.5-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1429dc332244b4ffcd6c527d3c32f811"
SRC_URI[sha256sum] = "b783008967efa45958e1b210bf70c2a3fa4f890ef39ed636a25740bd206988f9"
S = "${WORKDIR}/naoqi_bridge-release-release-kinetic-naoqi_driver_py-0.5.5-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('naoqi-bridge', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('naoqi-bridge', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/naoqi-bridge_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/naoqi-bridge-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/naoqi-bridge/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
