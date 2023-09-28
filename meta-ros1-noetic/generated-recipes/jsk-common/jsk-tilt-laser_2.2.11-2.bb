# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The jsk_tilt_laser package"
AUTHOR = "YoheiKakiuchi <youhei@jsk.imi.i.u-tokyo.ac.jp>"
ROS_AUTHOR = "YoheiKakiuchi <youhei@jsk.imi.i.u-tokyo.ac.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_common"
ROS_BPN = "jsk_tilt_laser"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    dynamic-reconfigure \
    laser-assembler \
    laser-filters \
    sensor-msgs \
    tf \
    tf-conversions \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    laser-assembler \
    laser-filters \
    robot-state-publisher \
    sensor-msgs \
    tf \
    tf-conversions \
    urg-node \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_common-release/archive/release/noetic/jsk_tilt_laser/2.2.11-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/jsk_tilt_laser"
SRC_URI = "git://github.com/tork-a/jsk_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "04723f377d28cdae46b0862c518b0e82ba887606"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
