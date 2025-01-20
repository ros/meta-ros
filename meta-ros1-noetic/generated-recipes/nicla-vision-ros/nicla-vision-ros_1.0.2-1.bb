# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Integration of the Arduino Nicla Vision board in the ROS world.      Sensors data from the Nicla Vision is collected and trasmited to the relevant ROS topics"
AUTHOR = "Davide Torielli <toridebraus@gmail.com>"
ROS_AUTHOR = "Davide Torielli <toridebraus@gmail.com>"
HOMEPAGE = "https://github.com/ADVRHumanoids/nicla_vision_ros/"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=5a034bfdd80f2941632b4629d4fe2295"

ROS_CN = "nicla_vision_ros"
ROS_BPN = "nicla_vision_ros"

ROS_BUILD_DEPENDS = " \
    audio-common-msgs \
    cv-bridge \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    audio-common-msgs \
    cv-bridge \
    rospy \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    audio-common-msgs \
    cv-bridge \
    gazebo-ros \
    robot-state-publisher \
    rospy \
    rviz \
    sensor-msgs \
    xacro \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ADVRHumanoids/nicla_vision_ros-release/archive/release/noetic/nicla_vision_ros/1.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/nicla_vision_ros"
SRC_URI = "git://github.com/ADVRHumanoids/nicla_vision_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "442713b988955e9339ff015e51713d21a9a98195"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
