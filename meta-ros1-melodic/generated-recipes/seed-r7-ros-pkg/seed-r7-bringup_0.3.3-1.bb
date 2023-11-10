# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The seed_r7_bringup package"
AUTHOR = "hi.kondo <hi.kondo@thk.co.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "seed_r7_ros_pkg"
ROS_BPN = "seed_r7_bringup"

ROS_BUILD_DEPENDS = " \
    controller-manager \
    robot-state-publisher \
    seed-r7-ros-controller \
    seed-r7-typef-moveit-config \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    controller-manager \
    robot-state-publisher \
    seed-r7-ros-controller \
    seed-r7-typef-moveit-config \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager \
    robot-state-publisher \
    seed-r7-ros-controller \
    seed-r7-typef-moveit-config \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/seed-solutions/seed_r7_ros_pkg-release/archive/release/melodic/seed_r7_bringup/0.3.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/seed_r7_bringup"
SRC_URI = "git://github.com/seed-solutions/seed_r7_ros_pkg-release;${ROS_BRANCH};protocol=https"
SRCREV = "2e78982224a8120e349a79a9d6b413a3e0b033eb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}