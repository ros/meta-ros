# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The jsk_rviz_plugins package"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://jsk-docs.readthedocs.io/en/latest/jsk_visualization/doc/jsk_rviz_plugins"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_visualization"
ROS_BPN = "jsk_rviz_plugins"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    image-geometry \
    jsk-footstep-msgs \
    jsk-gui-msgs \
    jsk-hark-msgs \
    jsk-recognition-msgs \
    jsk-recognition-utils \
    jsk-topic-tools \
    message-generation \
    mk \
    people-msgs \
    rosbuild \
    rviz \
    std-msgs \
    urdfdom-py \
    view-controller-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python-scipy} \
    cv-bridge \
    diagnostic-msgs \
    dynamic-reconfigure \
    geometry-msgs \
    image-geometry \
    image-publisher \
    jsk-footstep-msgs \
    jsk-gui-msgs \
    jsk-hark-msgs \
    jsk-recognition-msgs \
    jsk-recognition-utils \
    jsk-topic-tools \
    message-generation \
    people-msgs \
    posedetection-msgs \
    rviz \
    std-msgs \
    urdfdom-py \
    view-controller-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_visualization-release/archive/release/melodic/jsk_rviz_plugins/2.1.7-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/jsk_rviz_plugins"
SRC_URI = "git://github.com/tork-a/jsk_visualization-release;${ROS_BRANCH};protocol=https"
SRCREV = "6e74b01819e06e4ae8b0c42953e74a7e25a38635"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
