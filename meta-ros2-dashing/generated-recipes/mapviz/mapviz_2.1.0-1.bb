# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "mapviz"
AUTHOR = "P. J. Reed <preed@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/mapviz"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mapviz"
ROS_BPN = "mapviz"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    freeglut \
    geometry-msgs \
    glew \
    image-transport \
    libxi \
    libxmu \
    mapviz-interfaces \
    marti-common-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    std-srvs \
    swri-math-util \
    swri-transform-util \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    pkgconfig-native \
    qtbase-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    freeglut \
    geometry-msgs \
    glew \
    image-transport \
    libxi \
    libxmu \
    mapviz-interfaces \
    marti-common-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    std-srvs \
    swri-math-util \
    swri-transform-util \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    freeglut \
    geometry-msgs \
    glew \
    image-transport \
    libxi \
    libxmu \
    mapviz-interfaces \
    marti-common-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    rqt-gui \
    rqt-gui-cpp \
    std-srvs \
    swri-math-util \
    swri-transform-util \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/swri-robotics-gbp/mapviz-release/archive/release/dashing/mapviz/2.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/mapviz"
SRC_URI = "git://github.com/swri-robotics-gbp/mapviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "f599a126cd181fe64e51e94129b2d256eb12e72e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
