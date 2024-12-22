# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "RViz visualizations for polygons"
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "polygon_ros"
ROS_BPN = "polygon_rviz_plugins"

ROS_BUILD_DEPENDS = " \
    color-util \
    geometry-msgs \
    pluginlib \
    polygon-msgs \
    polygon-utils \
    rviz-common \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    color-util \
    geometry-msgs \
    pluginlib \
    polygon-msgs \
    polygon-utils \
    rviz-common \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    color-util \
    geometry-msgs \
    pluginlib \
    polygon-msgs \
    polygon-utils \
    rviz-common \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/polygon_ros-release/archive/release/iron/polygon_rviz_plugins/1.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/polygon_rviz_plugins"
SRC_URI = "git://github.com/ros2-gbp/polygon_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "85a044c473aab9f89e78e116f39d927a964362fa"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
