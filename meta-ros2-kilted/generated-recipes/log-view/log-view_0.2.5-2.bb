# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_kilted
inherit ros_superflore_generated

DESCRIPTION = "The log_view package provides a ncurses based terminal GUI for     viewing and filtering published ROS log messages.      This is an alternative to rqt_console and swri_console that doesn't depend     on qt and can be run directly in a terminal."
AUTHOR = "Marc Alban <marcalban@hatchbed.com>"
ROS_AUTHOR = "Marc Alban <marcalban@hatchbed.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "log_view"
ROS_BPN = "log_view"

ROS_BUILD_DEPENDS = " \
    ncurses \
    rcl-interfaces \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ncurses \
    rcl-interfaces \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-xclip} \
    ncurses \
    rcl-interfaces \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/log_view-release/archive/release/kilted/log_view/0.2.5-2.tar.gz
ROS_BRANCH ?= "branch=release/kilted/log_view"
SRC_URI = "git://github.com/ros2-gbp/log_view-release;${ROS_BRANCH};protocol=https"
SRCREV = "efacb65532f755bddf47497cec19e96c14639e77"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
