# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "pr2eus"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/pr2eus"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_pr2eus"
ROS_BPN = "pr2eus"

ROS_BUILD_DEPENDS = " \
    control-msgs \
    dynamic-reconfigure \
    euscollada \
    move-base-msgs \
    nav-msgs \
    pr2-controllers-msgs \
    pr2-description \
    pr2-mechanism-msgs \
    pr2-msgs \
    roseus \
    rosgraph-msgs \
    sound-play \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    control-msgs \
    dynamic-reconfigure \
    euscollada \
    move-base-msgs \
    nav-msgs \
    pr2-controllers-msgs \
    pr2-description \
    pr2-mechanism-msgs \
    pr2-msgs \
    roseus \
    sound-play \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-msgs \
    dynamic-reconfigure \
    euscollada \
    move-base-msgs \
    nav-msgs \
    pr2-controllers-msgs \
    pr2-description \
    pr2-mechanism-msgs \
    pr2-msgs \
    roseus \
    sound-play \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    pr2-gazebo \
    robot-state-publisher \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_pr2eus-release/archive/release/melodic/pr2eus/0.3.14-3.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2eus"
SRC_URI = "git://github.com/tork-a/jsk_pr2eus-release;${ROS_BRANCH};protocol=https"
SRCREV = "47815adbda74293701f2a2179d3e9f288b5bb83d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
