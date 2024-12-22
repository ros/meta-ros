# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "Common plugins for the Mapviz visualization tool"
AUTHOR = "Southwest Research Institute <swri-robotics@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/mapviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mapviz"
ROS_BPN = "mapviz_plugins"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    cv-bridge \
    gps-msgs \
    image-transport \
    map-msgs \
    mapviz \
    marti-common-msgs \
    marti-nav-msgs \
    marti-sensor-msgs \
    marti-visualization-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    rclcpp-action \
    ros-environment \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    swri-image-util \
    swri-math-util \
    swri-route-util \
    swri-transform-util \
    tf2 \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    qtbase-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    cv-bridge \
    gps-msgs \
    image-transport \
    map-msgs \
    mapviz \
    marti-common-msgs \
    marti-nav-msgs \
    marti-sensor-msgs \
    marti-visualization-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    rclcpp-action \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    swri-image-util \
    swri-math-util \
    swri-route-util \
    swri-transform-util \
    tf2 \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    cv-bridge \
    gps-msgs \
    image-transport \
    map-msgs \
    mapviz \
    marti-common-msgs \
    marti-nav-msgs \
    marti-sensor-msgs \
    marti-visualization-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    rclcpp-action \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    swri-image-util \
    swri-math-util \
    swri-route-util \
    swri-transform-util \
    tf2 \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/mapviz-release/archive/release/iron/mapviz_plugins/2.4.3-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/mapviz_plugins"
SRC_URI = "git://github.com/ros2-gbp/mapviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "f229ba2b0a6bcd49a3b18b173b5200121747ab2a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
