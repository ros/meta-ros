# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "<p>       MoveIt Resources for testing: Fanuc M-10iA.     </p>     <p>       A project-internal configuration for testing in MoveIt.     </p>"
AUTHOR = "Dave Coleman <dave@dav.ee>"
ROS_AUTHOR = "Dave Coleman <dave@dav.ee>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit_resources"
ROS_BPN = "moveit_resources_fanuc_moveit_config"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    moveit-resources-fanuc-description \
    robot-state-publisher \
    tf2-ros \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/moveit_resources-release/archive/release/humble/moveit_resources_fanuc_moveit_config/2.0.7-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/moveit_resources_fanuc_moveit_config"
SRC_URI = "git://github.com/ros2-gbp/moveit_resources-release;${ROS_BRANCH};protocol=https"
SRCREV = "edf77cd9002406349d8846c7fa5f4147c6e2a190"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
