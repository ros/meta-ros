# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Launch files to upload the robot description and start the controllers"
AUTHOR = "Jordi Pages <jordi.pages@pal-robotics.com>"
ROS_AUTHOR = "Bence Magyar <bence.magyar@pal-robotics.com>"
HOMEPAGE = "https://github.com/pal-robotics/tiago_simulation"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "tiago_robot"
ROS_BPN = "tiago_bringup"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    joy-linux \
    joy-teleop \
    launch-pal \
    play-motion2 \
    teleop-tools-msgs \
    tiago-controller-configuration \
    tiago-description \
    twist-mux \
    twist-mux-msgs \
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

# matches with: https://github.com/pal-gbp/tiago_robot-release/archive/release/humble/tiago_bringup/4.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/tiago_bringup"
SRC_URI = "git://github.com/pal-gbp/tiago_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "170e638554f43592ddc60cd426c801f222068224"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
