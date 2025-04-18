# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Meta package for the autoware_msgs packages"
AUTHOR = "M. Fatih Cırıt <mfc@autoware.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "autoware_msgs"
ROS_BPN = "autoware_msgs"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    autoware-common-msgs \
    autoware-control-msgs \
    autoware-localization-msgs \
    autoware-map-msgs \
    autoware-perception-msgs \
    autoware-planning-msgs \
    autoware-sensing-msgs \
    autoware-system-msgs \
    autoware-v2x-msgs \
    autoware-vehicle-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/autoware_msgs-release/archive/release/rolling/autoware_msgs/1.6.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/autoware_msgs"
SRC_URI = "git://github.com/ros2-gbp/autoware_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "169929011c6db7799400e2e8ce9b98f53b4b859a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
