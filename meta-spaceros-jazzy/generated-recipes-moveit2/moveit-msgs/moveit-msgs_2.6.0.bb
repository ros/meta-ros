# Recipe created by mash
#
# Copyright (c) 2025 Open Source Robotics Foundation, Inc.

inherit ros_distro_jazzy
inherit mash_generated

DESCRIPTION = "Messages, services and actions used by MoveIt"
AUTHOR = "Dave Coleman <dave@dav.ee>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit_msgs"
ROS_BPN = "moveit_msgs"

ROS_BUILD_DEPENDS = "\
    rosidl-default-generators\
    octomap-msgs\
    action-msgs\
    sensor-msgs\
    geometry-msgs\
    trajectory-msgs\
    shape-msgs\
    object-recognition-msgs\
    std-msgs\
"

ROS_BUILDTOOL_DEPENDS = "\
    ament-cmake-native\
"

ROS_EXPORT_DEPENDS = "\
    octomap-msgs\
    action-msgs\
    sensor-msgs\
    geometry-msgs\
    trajectory-msgs\
    shape-msgs\
    object-recognition-msgs\
    std-msgs\
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime\
    octomap-msgs\
    action-msgs\
    sensor-msgs\
    geometry-msgs\
    trajectory-msgs\
    shape-msgs\
    object-recognition-msgs\
    std-msgs\
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = "\
    ament-lint-auto\
    ament-lint-cmake\
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed
# them to build this package (even though we actually don't) so that they're
# guaranteed to have been staged should this package appear in another's
# DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "branch=release/jazzy/moveit_msgs"
SRC_URI = "git://github.com/ros2-gbp/moveit_msgs-release.git;${ROS_BRANCH};protocol=https"
SRCREV = "5608ec22e5a4985a91834e70ceba8548e294949c"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
