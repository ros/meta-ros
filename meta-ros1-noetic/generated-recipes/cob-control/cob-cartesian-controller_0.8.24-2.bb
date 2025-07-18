# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "This package provides nodes that broadcast tf-frames along various (model-based) Cartesian paths (e.g. Linear, Circular).     The tf-frames are interpolated using a given velocity profile (e.g. Ramp, Sinoid) and can be used as targets for the cob_frame_tracker/cob_twist_controller."
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Christoph Mark <fxm-cm@ipa.fhg.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_control"
ROS_BPN = "cob_cartesian_controller"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    cob-srvs \
    geometry-msgs \
    message-generation \
    roscpp \
    roslint \
    std-msgs \
    std-srvs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    python3-setuptools-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    cob-srvs \
    geometry-msgs \
    roscpp \
    std-msgs \
    std-srvs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    boost \
    cob-frame-tracker \
    cob-script-server \
    cob-srvs \
    cob-twist-controller \
    geometry-msgs \
    message-runtime \
    robot-state-publisher \
    roscpp \
    rospy \
    rviz \
    std-msgs \
    std-srvs \
    tf \
    topic-tools \
    visualization-msgs \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/4am-robotics/cob_control-release/archive/release/noetic/cob_cartesian_controller/0.8.24-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/cob_cartesian_controller"
SRC_URI = "git://github.com/4am-robotics/cob_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "f85b700fd61f2f673fd23718fc1b2689660c7761"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
