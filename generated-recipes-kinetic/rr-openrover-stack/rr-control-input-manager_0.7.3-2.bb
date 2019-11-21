# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Filter velocity commands by ensuring that message time stamps do not exceed given timeout thresholds."
AUTHOR = "Nicholas Padilla <padilla@digilabs.io>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rr_openrover_stack"
ROS_BPN = "rr_control_input_manager"

ROS_BUILD_DEPENDS = " \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/RoverRobotics-release/rr_openrover_stack-release/archive/release/kinetic/rr_control_input_manager/0.7.3-2.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "761eefc4c5dc5b20a35b0fb7be257619"
SRC_URI[sha256sum] = "e7a1593e799125997c0d35e0755d842fc72fca548e18bd3dc3f1eb26544bbb18"
S = "${WORKDIR}/rr_openrover_stack-release-release-kinetic-rr_control_input_manager-0.7.3-2"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rr-openrover-stack', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('rr-openrover-stack', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rr-openrover-stack/rr-openrover-stack_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rr-openrover-stack/rr-openrover-stack-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rr-openrover-stack/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/rr-openrover-stack/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
