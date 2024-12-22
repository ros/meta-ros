# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Standalone GUI tool for editing node parameters at runtime."
AUTHOR = "Team Spatzenhirn <team-spatzenhirn@uni-ulm.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=92566b45c3390e5178465bcaade208b7"

ROS_CN = "rig_reconfigure"
ROS_BPN = "rig_reconfigure"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    glfw \
    rclcpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    git-native \
"

ROS_EXPORT_DEPENDS = " \
    ament-index-cpp \
    glfw \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-cpp \
    glfw \
    rclcpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rig_reconfigure-release/archive/release/humble/rig_reconfigure/1.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/rig_reconfigure"
SRC_URI = "git://github.com/ros2-gbp/rig_reconfigure-release;${ROS_BRANCH};protocol=https"
SRCREV = "2232bf46a4a40109a961a0e2b3139b397414f3de"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
