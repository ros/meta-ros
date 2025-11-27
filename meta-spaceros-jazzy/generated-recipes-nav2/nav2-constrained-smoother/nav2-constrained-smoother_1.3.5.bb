# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Ceres constrained smoother"
AUTHOR = "Matej Vargovcik <vargovcik@robotechvision.com>"
HOMEPAGE = "https://wiki.ros.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "nav2_constrained_smoother"
ROS_BPN = "nav2_constrained_smoother"

ROS_BUILD_DEPENDS = "\
    nav2-common\
    angles\
    rclcpp\
    nav2-util\
    nav2-msgs\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
    ceres-solver\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    nav2-common\
    angles\
    rclcpp\
    nav2-util\
    nav2-msgs\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
    ceres-solver\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    nav2-common\
    angles\
    rclcpp\
    nav2-util\
    nav2-msgs\
    nav2-costmap-2d\
    nav2-core\
    pluginlib\
    ceres-solver\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-common\
    ament-lint-auto\
    ament-cmake-gtest\
    ament-cmake-pytest\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/nav2_constrained_smoother"
SRC_URI = "git://github.com/SteveMacenski/navigation2-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "aad59bf4cb8951391a71ecbfcbd8f46e2d1ecb4f"
S = "${WORKDIR}/git/nav2_constrained_smoother"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
