# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Common rviz API, used by rviz plugins and applications."
AUTHOR = "Alejandro Hernandez Cordero <alejandro@openrobotics.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "https://github.com/ros2/rviz/blob/ros2/README.md"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz_common"
ROS_BPN = "rviz_common"

ROS_BUILD_DEPENDS = "\
    qtsvg\
    qtbase\
    geometry-msgs\
    pluginlib\
    rclcpp\
    resource-retriever\
    rviz-ogre-vendor\
    rviz-rendering\
    sensor-msgs\
    std-msgs\
    std-srvs\
    tf2\
    tf2-ros\
    message-filters\
    tinyxml2-vendor\
    urdf\
    yaml-cpp-vendor\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    qtbase\
    geometry-msgs\
    pluginlib\
    rclcpp\
    resource-retriever\
    rviz-ogre-vendor\
    rviz-rendering\
    sensor-msgs\
    std-msgs\
    std-srvs\
    tf2\
    tf2-ros\
    message-filters\
    tinyxml2-vendor\
    urdf\
    yaml-cpp-vendor\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    qtbase\
    qtbase\
    qtbase\
    qtsvg\
    qtbase\
    geometry-msgs\
    pluginlib\
    rclcpp\
    resource-retriever\
    rviz-ogre-vendor\
    rviz-rendering\
    sensor-msgs\
    std-msgs\
    std-srvs\
    tf2\
    tf2-ros\
    message-filters\
    tinyxml2-vendor\
    urdf\
    yaml-cpp-vendor\
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
    ament-lint-auto\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/rviz_common"
SRC_URI = "git://github.com/ros2-gbp/rviz-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "49269c9af638b787a48b8847781b7b1988f83b4d"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/rviz_common"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
