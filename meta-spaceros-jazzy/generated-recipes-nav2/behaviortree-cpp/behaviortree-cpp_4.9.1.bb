# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "This package provides the Behavior Trees core library."
AUTHOR = "Davide Faconti <davide.faconti@gmail.com>"
ROS_AUTHOR = "Davide Faconti"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "behaviortree_cpp"
ROS_BPN = "behaviortree_cpp"

ROS_BUILD_DEPENDS = "\
    ros-environment\
    rclcpp\
    ament-index-cpp\
    sqlite3\
    zeromq\
    libtinyxml2\
    tinyxml2-vendor\
"

ROS_BUILDTOOL_DEPENDS = "\
    git-native\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    rclcpp\
    ament-index-cpp\
    sqlite3\
    zeromq\
    libtinyxml2\
    tinyxml2-vendor\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclcpp\
    ament-index-cpp\
    sqlite3\
    zeromq\
    libtinyxml2\
    tinyxml2-vendor\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-cmake-gtest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we
# needed them to build this package (even though we actually don't) so
# that they're guaranteed to have been staged should this package appear
# in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=dynrpm/jazzy/behaviortree_cpp"
SRC_URI = "git://github.com/ros2-gbp/behaviortree_cpp_v4-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "63ec2bcf4d295ed4bb4fac633ab17ac603de0f03"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
