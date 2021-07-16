# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Common plugins for the Mapviz visualization tool"
AUTHOR = "Marc Alban <malban@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/mapviz"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mapviz"
ROS_BPN = "mapviz_plugins"

ROS_BUILD_DEPENDS = " \
    actionlib \
    cv-bridge \
    gps-common \
    image-transport \
    map-msgs \
    mapviz \
    marti-common-msgs \
    marti-nav-msgs \
    marti-sensor-msgs \
    marti-visualization-msgs \
    move-base-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    roscpp \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    swri-image-util \
    swri-math-util \
    swri-route-util \
    swri-transform-util \
    swri-yaml-util \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    qtbase-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    cv-bridge \
    gps-common \
    image-transport \
    map-msgs \
    mapviz \
    marti-common-msgs \
    marti-nav-msgs \
    marti-sensor-msgs \
    marti-visualization-msgs \
    move-base-msgs \
    nav-msgs \
    pluginlib \
    roscpp \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    swri-image-util \
    swri-math-util \
    swri-route-util \
    swri-transform-util \
    swri-yaml-util \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    cv-bridge \
    gps-common \
    image-transport \
    map-msgs \
    mapviz \
    marti-common-msgs \
    marti-nav-msgs \
    marti-sensor-msgs \
    marti-visualization-msgs \
    move-base-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    roscpp \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    swri-image-util \
    swri-math-util \
    swri-route-util \
    swri-transform-util \
    swri-yaml-util \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/swri-robotics-gbp/mapviz-release/archive/release/melodic/mapviz_plugins/1.4.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/mapviz_plugins"
SRC_URI = "git://github.com/swri-robotics-gbp/mapviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "1c88be779019297fba47b20b451ba7245ef19f75"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
