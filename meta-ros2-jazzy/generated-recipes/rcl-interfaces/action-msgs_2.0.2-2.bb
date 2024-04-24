# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Messages and service definitions common among all ROS actions."
AUTHOR = "Geoffrey Biggs <geoff@openrobotics.org>"
ROS_AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rcl_interfaces"
ROS_BPN = "action_msgs"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    service-msgs \
    unique-identifier-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-core-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    builtin-interfaces \
    service-msgs \
    unique-identifier-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    rosidl-core-runtime \
    service-msgs \
    unique-identifier-msgs \
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

# matches with: https://github.com/ros2-gbp/rcl_interfaces-release/archive/release/jazzy/action_msgs/2.0.2-2.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/action_msgs"
SRC_URI = "git://github.com/ros2-gbp/rcl_interfaces-release;${ROS_BRANCH};protocol=https"
SRCREV = "6e0b31e86079a661e1aa4a13cab22c4c5c6a0c73"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
