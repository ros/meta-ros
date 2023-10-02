# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "EusLisp client for ROS Robot Operating System."
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://pr.willowgarage.com/wiki/roseus"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_roseus"
ROS_BPN = "roseus"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    actionlib-tutorials \
    angles \
    coreutils \
    dynamic-reconfigure \
    euslisp \
    geneus \
    geometry-msgs \
    jskeus \
    message-generation \
    mk \
    rosbash \
    rosbuild \
    roscpp \
    roslang \
    rosmsg \
    rosnode \
    rospack \
    rostest \
    rostopic \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    actionlib-tutorials \
    dynamic-reconfigure \
    euslisp \
    geneus \
    geometry-msgs \
    jskeus \
    message-runtime \
    rosbash \
    roscpp \
    roslang \
    rosmsg \
    rosnode \
    rospack \
    rostest \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    actionlib-tutorials \
    dynamic-reconfigure \
    euslisp \
    geneus \
    geometry-msgs \
    jskeus \
    message-runtime \
    rosbash \
    roscpp \
    roslang \
    rosmsg \
    rosnode \
    rospack \
    rostest \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    tf2-ros \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-xvfb} \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_roseus-release/archive/release/melodic/roseus/1.7.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/roseus"
SRC_URI = "git://github.com/tork-a/jsk_roseus-release;${ROS_BRANCH};protocol=https"
SRCREV = "d99fd3f664358226005b938dde48459ef8e8fa63"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
