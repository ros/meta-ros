# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Several default plugins for rviz to cover the basic functionality."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "https://github.com/ros2/rviz/blob/ros2/README.md"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz_default_plugins"
ROS_BPN = "rviz_default_plugins"

ROS_BUILD_DEPENDS = "\
    qtbase\
    rviz-ogre-vendor\
    geometry-msgs\
    gz-math-vendor\
    image-transport\
    interactive-markers\
    laser-geometry\
    nav-msgs\
    map-msgs\
    pluginlib\
    point-cloud-transport\
    rclcpp\
    resource-retriever\
    rviz-common\
    rviz-rendering\
    tf2\
    tf2-geometry-msgs\
    tf2-ros\
    urdf\
    visualization-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-ros-native\
"

ROS_EXPORT_DEPENDS = "\
    rviz-ogre-vendor\
    geometry-msgs\
    gz-math-vendor\
    image-transport\
    interactive-markers\
    laser-geometry\
    nav-msgs\
    map-msgs\
    pluginlib\
    point-cloud-transport\
    rclcpp\
    resource-retriever\
    rviz-common\
    rviz-rendering\
    tf2\
    tf2-geometry-msgs\
    tf2-ros\
    urdf\
    visualization-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    qtbase\
    qtbase\
    qtbase\
    qtbase\
    rviz-ogre-vendor\
    geometry-msgs\
    gz-math-vendor\
    image-transport\
    interactive-markers\
    laser-geometry\
    nav-msgs\
    map-msgs\
    pluginlib\
    point-cloud-transport\
    rclcpp\
    resource-retriever\
    rviz-common\
    rviz-rendering\
    tf2\
    tf2-geometry-msgs\
    tf2-ros\
    urdf\
    visualization-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-cppcheck\
    ament-cmake-cpplint\
    ament-cmake-gmock\
    ament-cmake-gtest\
    ament-cmake-lint-cmake\
    ament-cmake-uncrustify\
    ament-cmake-xmllint\
    ament-index-cpp\
    ament-lint-auto\
    rviz-rendering-tests\
    rviz-visual-testing-framework\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/rviz_default_plugins"
SRC_URI = "git://github.com/ros2-gbp/rviz-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "f57212d2574cea688e2dcbd3352ab9be93203fa6"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/rviz_default_plugins"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
