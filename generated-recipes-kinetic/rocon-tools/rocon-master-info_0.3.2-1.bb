# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Publish master information - name, description, icon."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "http://ros.org/wiki/rocon_master_info"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rocon_tools"
ROS_BPN = "rocon_master_info"

ROS_BUILD_DEPENDS = " \
    python-catkin-pkg \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    python-rospkg \
    rocon-bubble-icons \
    rocon-console \
    rocon-icons \
    rocon-python-comms \
    rocon-python-utils \
    rocon-std-msgs \
    rocon-uri \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    python-rospkg \
    rocon-bubble-icons \
    rocon-console \
    rocon-icons \
    rocon-python-comms \
    rocon-python-utils \
    rocon-std-msgs \
    rocon-uri \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/yujinrobot-release/rocon_tools-release/archive/release/kinetic/rocon_master_info/0.3.2-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "de96bb632b58a371fafdd9f130307bce"
SRC_URI[sha256sum] = "72cd378db75a699c55e7915f8e0d65dae7cc3eb4f40ef100fc1c1a96646927c7"
S = "${WORKDIR}/rocon_tools-release-release-kinetic-rocon_master_info-0.3.2-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rocon-tools', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rocon-tools', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/rocon-tools_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/rocon-tools-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rocon-tools/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
