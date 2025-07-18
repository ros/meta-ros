# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "cob_undercarriage_ctrl implements a controller for the omnidirectional base of Care-O-bot 3 on joint level. For a given Pltf-Twist the according wheel steering angles and linear wheel velocities are calculated based on the principle of rigid body motion. Each joint is than controlled individually to achieve the computed position and velocity"
AUTHOR = "Matthias Gruhler <mig@ipa.fhg.de>"
ROS_AUTHOR = "Christian Connette"
HOMEPAGE = "http://ros.org/wiki/cob_undercarriage_ctrl"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_driver"
ROS_BPN = "cob_undercarriage_ctrl"

ROS_BUILD_DEPENDS = " \
    cob-msgs \
    cob-utilities \
    control-msgs \
    diagnostic-msgs \
    diagnostic-updater \
    geometry-msgs \
    nav-msgs \
    roscpp \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cob-msgs \
    cob-utilities \
    control-msgs \
    diagnostic-msgs \
    diagnostic-updater \
    geometry-msgs \
    nav-msgs \
    roscpp \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cob-msgs \
    cob-utilities \
    control-msgs \
    diagnostic-msgs \
    diagnostic-updater \
    geometry-msgs \
    nav-msgs \
    roscpp \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/4am-robotics/cob_driver-release/archive/release/noetic/cob_undercarriage_ctrl/0.7.17-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cob_undercarriage_ctrl"
SRC_URI = "git://github.com/4am-robotics/cob_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "11cf3ca7c3433f256918af246265f0a00c970711"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
