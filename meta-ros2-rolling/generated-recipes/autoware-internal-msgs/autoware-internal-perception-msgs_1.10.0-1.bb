# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Autoware internal perception messages package."
AUTHOR = "M. Fatih Cırıt <mfc@leodrive.ai>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "autoware_internal_msgs"
ROS_BPN = "autoware_internal_perception_msgs"

ROS_BUILD_DEPENDS = " \
    autoware-perception-msgs \
    builtin-interfaces \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    autoware-perception-msgs \
    builtin-interfaces \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    autoware-perception-msgs \
    builtin-interfaces \
    rosidl-default-runtime \
    sensor-msgs \
    std-msgs \
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

# matches with: https://github.com/ros2-gbp/autoware_internal_msgs-release/archive/release/rolling/autoware_internal_perception_msgs/1.10.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/autoware_internal_perception_msgs"
SRC_URI = "git://github.com/ros2-gbp/autoware_internal_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "97dfe5ce82f60af6cb4425f05d7a6a5321f55ea8"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
