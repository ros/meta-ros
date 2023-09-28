# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Virtual sensor that uses semantic map information to &quot;see&quot; obstacles undetectable by robot sensors.              Current implementation cannot read obstacles from YAML files. Until this feature gets implemented, we       use auxiliary scripts to read and publish files' content. Data directory contains some example files."
AUTHOR = "Jihoon Lee <jihoonl@yujinrobot.com>"
ROS_AUTHOR = "Jorge Santos"
HOMEPAGE = "http://ros.org/wiki/yocs_virtual_sensor"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "yujin_ocs"
ROS_BPN = "yocs_virtual_sensor"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    roscpp \
    sensor-msgs \
    tf \
    yocs-math-toolkit \
    yocs-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    roscpp \
    rospy \
    rospy-message-converter \
    sensor-msgs \
    tf \
    visualization-msgs \
    yocs-math-toolkit \
    yocs-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    roscpp \
    rospy \
    rospy-message-converter \
    sensor-msgs \
    tf \
    visualization-msgs \
    yocs-math-toolkit \
    yocs-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yujinrobot-release/yujin_ocs-release/archive/release/melodic/yocs_virtual_sensor/0.8.2-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/yocs_virtual_sensor"
SRC_URI = "git://github.com/yujinrobot-release/yujin_ocs-release;${ROS_BRANCH};protocol=https"
SRCREV = "aad7b85f129850a7bf00e23bdc98fe00cc5c5de9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
