# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Provides a ROS interface to Ubiquity Robotics Magni motor controllers"
AUTHOR = "Rohan Agrawal <rohan@aleopile.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ubiquity_motor"
ROS_BPN = "ubiquity_motor"

ROS_BUILD_DEPENDS = " \
    controller-manager \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    hardware-interface \
    nav-msgs \
    roscpp \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    hardware-interface \
    nav-msgs \
    std-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    diagnostic-updater \
    diff-drive-controller \
    dynamic-reconfigure \
    geometry-msgs \
    hardware-interface \
    joint-state-controller \
    nav-msgs \
    python3-requests \
    std-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/UbiquityRobotics-release/ubiquity_motor-release/archive/release/noetic/ubiquity_motor/0.13.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/ubiquity_motor"
SRC_URI = "git://github.com/UbiquityRobotics-release/ubiquity_motor-release;${ROS_BRANCH};protocol=https"
SRCREV = "6cd52a8d9a7871f875dcc8d7600b69f009d73077"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
