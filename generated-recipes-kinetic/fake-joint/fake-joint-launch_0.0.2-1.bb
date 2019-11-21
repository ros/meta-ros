# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Collection of the launch files for fake_joint_driver."
AUTHOR = "Tokyo Opensource Robotics Kyokai (TORK) Developer Team <dev@opensource-robotics.tokyo.jp>"
ROS_AUTHOR = "Ryosuke Tajima <ryosuke.tajima@opensource-robotics.tokyo.jp>"
HOMEPAGE = "http://wiki.ros.org/fake_joint_launch"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "fake_joint"
ROS_BPN = "fake_joint_launch"

ROS_BUILD_DEPENDS = " \
    fake-joint-driver \
    roslaunch \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    fake-joint-driver \
    roslaunch \
    rostest \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    abb-irb2400-support \
    controller-manager \
    denso-ros-control \
    fake-joint-driver \
    nextage-description \
    pr2-description \
    robot-state-publisher \
    roslaunch \
    rostest \
    rviz \
    tra1-description \
    ur-description \
    vs060 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/tork-a/fake_joint-release/archive/release/kinetic/fake_joint_launch/0.0.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0630ed28f7a346c63e9524d9e51571cb"
SRC_URI[sha256sum] = "3c7f30a7201c2463f705eb8f0d3fc815d49ebf3cc839c8b68b28f86ee6fd0ee1"
S = "${WORKDIR}/fake_joint-release-release-kinetic-fake_joint_launch-0.0.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('fake-joint', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('fake-joint', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fake-joint/fake-joint_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fake-joint/fake-joint-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fake-joint/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/fake-joint/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
