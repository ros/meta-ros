# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "\
    <p>\
    MoveIt Resources for testing: Fanuc M-10iA.\
    </p>\
    <p>\
    A project-internal configuration for testing in MoveIt.\
    </p>\
"
AUTHOR = "Dave Coleman <dave@dav.ee>"
ROS_AUTHOR = "Dave Coleman <dave@dav.ee>"
HOMEPAGE = "http://moveit.ros.org"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit_resources_fanuc_moveit_config"
ROS_BPN = "moveit_resources_fanuc_moveit_config"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    ros2cli-common-extensions\
    joint-state-publisher\
    robot-state-publisher\
    tf2-ros\
    controller-manager\
    position-controllers\
    xacro\
    moveit-resources-fanuc-description\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/moveit_resources_fanuc_moveit_config"
SRC_URI = "git://github.com/ros2-gbp/moveit_resources-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "7ad85a6011daa6d1cbc7a6c929d252eda8606fa2"
S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/moveit_resources_fanuc_moveit_config"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
