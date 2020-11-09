# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "cob_lookat_action"
AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
ROS_AUTHOR = "Felix Messmer <fxm@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/cob_manipulation/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_manipulation"
ROS_BPN = "cob_lookat_action"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    angles \
    control-msgs \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    message-generation \
    move-base-msgs \
    orocos-kdl \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    angles \
    control-msgs \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    move-base-msgs \
    orocos-kdl \
    roscpp \
    sensor-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    angles \
    control-msgs \
    geometry-msgs \
    kdl-conversions \
    kdl-parser \
    message-runtime \
    move-base-msgs \
    orocos-kdl \
    roscpp \
    rospy \
    sensor-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/cob_manipulation-release/archive/release/melodic/cob_lookat_action/0.7.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/cob_lookat_action"
SRC_URI = "git://github.com/ipa320/cob_manipulation-release;${ROS_BRANCH};protocol=https"
SRCREV = "ab9bc486ec49ae8e39b4caaba74c172c9cb79613"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
