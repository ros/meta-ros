# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Interaction management for human interactive agents in the concert."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "http://ros.org/wiki/rocon_interactions"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rocon_tools"
ROS_BPN = "rocon_interactions"

ROS_BUILD_DEPENDS = " \
    ${PYTHON_PN}-catkin-pkg \
    roslint \
    rostest \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    genpy \
    rocon-app-manager-msgs \
    rocon-bubble-icons \
    rocon-console \
    rocon-icons \
    rocon-interaction-msgs \
    rocon-python-comms \
    rocon-python-utils \
    rocon-std-msgs \
    rocon-uri \
    rospy \
    std-msgs \
    unique-id \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    genpy \
    rocon-app-manager-msgs \
    rocon-bubble-icons \
    rocon-console \
    rocon-icons \
    rocon-interaction-msgs \
    rocon-python-comms \
    rocon-python-utils \
    rocon-std-msgs \
    rocon-uri \
    rospy \
    std-msgs \
    unique-id \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yujinrobot-release/rocon_tools-release/archive/release/melodic/rocon_interactions/0.3.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rocon_interactions"
SRC_URI = "git://github.com/yujinrobot-release/rocon_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "546ea470a666fbab7dc8d47005e72170ce0953d4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
