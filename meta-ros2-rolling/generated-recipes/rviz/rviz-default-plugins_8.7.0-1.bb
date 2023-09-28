# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Several default plugins for rviz to cover the basic functionality."
AUTHOR = "Jacob Perron <jacob@openrobotics.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "https://github.com/ros2/rviz/blob/ros2/README.md"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz"
ROS_BPN = "rviz_default_plugins"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    map-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    resource-retriever \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    map-msgs \
    nav-msgs \
    pluginlib \
    rclcpp \
    resource-retriever \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    map-msgs \
    nav-msgs \
    pluginlib \
    qtbase \
    rclcpp \
    resource-retriever \
    rviz-common \
    rviz-ogre-vendor \
    rviz-rendering \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    urdf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-lint-cmake \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
    ament-index-cpp \
    ament-lint-auto \
    rviz-rendering-tests \
    rviz-visual-testing-framework \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rviz-release/archive/release/rolling/rviz_default_plugins/8.7.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rviz_default_plugins"
SRC_URI = "git://github.com/ros2-gbp/rviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "96c1ba8aa9ef40503c826c8b4d0036da6bffd735"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
