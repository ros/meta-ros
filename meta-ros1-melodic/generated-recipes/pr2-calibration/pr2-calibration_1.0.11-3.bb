# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The pr2_calibration package"
AUTHOR = "Dave Feil-Seifer <dave@cse.unr.edu>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "TODO"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=2feaf30a620f46f06a4b016624acf46f"

ROS_CN = "pr2_calibration"
ROS_BPN = "pr2_calibration"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dense-laser-assembler \
    laser-joint-processor \
    laser-joint-projector \
    pr2-calibration-launch \
    pr2-dense-laser-snapshotter \
    pr2-se-calibration-launch \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dense-laser-assembler \
    laser-joint-processor \
    laser-joint-projector \
    pr2-calibration-launch \
    pr2-dense-laser-snapshotter \
    pr2-se-calibration-launch \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/UNR-RoboticsResearchLab/pr2_calibration-release/archive/release/melodic/pr2_calibration/1.0.11-3.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2_calibration"
SRC_URI = "git://github.com/UNR-RoboticsResearchLab/pr2_calibration-release;${ROS_BRANCH};protocol=https"
SRCREV = "7bafec45ad80badc9cd26cd676049ae574ecabe7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
