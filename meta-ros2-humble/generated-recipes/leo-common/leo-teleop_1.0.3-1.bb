# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Scripts and launch files for Leo Rover teleoperation"
AUTHOR = "Fictionlab <support@fictionlab.pl>"
ROS_AUTHOR = "Błażej Sowa <blazej@fictionlab.pl>"
HOMEPAGE = "http://wiki.ros.org/leo_teleop"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "leo_common"
ROS_BPN = "leo_teleop"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joy \
    teleop-twist-joy \
    teleop-twist-keyboard \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/fictionlab-gbp/leo_common-ros2-release/archive/release/humble/leo_teleop/1.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/leo_teleop"
SRC_URI = "git://github.com/fictionlab-gbp/leo_common-ros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "367f1a885c01e835f435320f3ac6d16f0f15670a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
