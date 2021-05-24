# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "The package provides the environment variables `ROS_VERSION` and `ROS_DISTRO`."
AUTHOR = "Steven! Ragnarök <steven@openrobotics.org>"
ROS_AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://github.com/ros/ros_environment"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros_environment"
ROS_BPN = "ros_environment"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-core-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros_environment-release/archive/release/galactic/ros_environment/3.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/ros_environment"
SRC_URI = "git://github.com/ros2-gbp/ros_environment-release;${ROS_BRANCH};protocol=https"
SRCREV = "ecb3e3030e718e4d1ea6c5e7a8c1ee7da43b51a7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
