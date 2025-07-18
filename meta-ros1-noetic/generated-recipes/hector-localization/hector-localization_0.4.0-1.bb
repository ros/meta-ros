# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The hector_localization stack is a collection of packages, that provide the full 6DOF pose of a robot or platform.     It uses various sensor sources, which are fused using an Extended Kalman filter.      Acceleration and angular rates from an inertial measurement unit (IMU) serve as primary measurements.     The usage of other sensors is application-dependent. The hector_localization stack currently supports     GPS, magnetometer, barometric pressure sensors and other external sources that provide a geometry_msgs/PoseWithCovariance     message via the poseupdate topic."
AUTHOR = "Johannes Meyer <joh@nnes-meyer.de>"
ROS_AUTHOR = "Johannes Meyer <joh@nnes-meyer.de>"
HOMEPAGE = "http://ros.org/wiki/hector_localization"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "hector_localization"
ROS_BPN = "hector_localization"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    hector-pose-estimation \
    hector-pose-estimation-core \
    message-to-tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    hector-pose-estimation \
    hector-pose-estimation-core \
    message-to-tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tu-darmstadt-ros-pkg-gbp/hector_localization-release/archive/release/noetic/hector_localization/0.4.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/hector_localization"
SRC_URI = "git://github.com/tu-darmstadt-ros-pkg-gbp/hector_localization-release;${ROS_BRANCH};protocol=https"
SRCREV = "27cd84ecbe0f6b7ace76559eddd16e6d11910007"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
