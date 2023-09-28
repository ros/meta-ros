# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The seed_r7_samples package"
AUTHOR = "Yasuto Shiigi <y.shiigi@thk.co.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "seed_r7_ros_pkg"
ROS_BPN = "seed_r7_samples"

ROS_BUILD_DEPENDS = " \
    moveit-commander \
    moveit-simple-controller-manager \
    rviz \
    rviz-plugin-tutorials \
    seed-r7-bringup \
    seed-r7-moveit-config \
    seed-r7-navigation \
    seed-r7-robot-interface \
    seed-r7-ros-controller \
    seed-r7-typef-moveit-config \
    smach-ros \
    smach-viewer \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    moveit-commander \
    moveit-simple-controller-manager \
    rviz \
    rviz-plugin-tutorials \
    seed-r7-bringup \
    seed-r7-moveit-config \
    seed-r7-navigation \
    seed-r7-robot-interface \
    seed-r7-ros-controller \
    seed-r7-typef-moveit-config \
    smach-ros \
    smach-viewer \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    moveit-commander \
    moveit-simple-controller-manager \
    rviz \
    rviz-plugin-tutorials \
    seed-r7-bringup \
    seed-r7-moveit-config \
    seed-r7-navigation \
    seed-r7-robot-interface \
    seed-r7-ros-controller \
    seed-r7-typef-moveit-config \
    smach-ros \
    smach-viewer \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/seed-solutions/seed_r7_ros_pkg-release/archive/release/melodic/seed_r7_samples/0.3.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/seed_r7_samples"
SRC_URI = "git://github.com/seed-solutions/seed_r7_ros_pkg-release;${ROS_BRANCH};protocol=https"
SRCREV = "8e0dae4387cda0480fd60e88633fa178a2a02606"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
