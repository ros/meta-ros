# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Messages for transmitting audio via ROS"
AUTHOR = "Austin Hendrix <namniart@gmail.com>"
ROS_AUTHOR = "Nate Koenig"
HOMEPAGE = "http://ros.org/wiki/audio_common_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

ROS_CN = "audio_common"
ROS_BPN = "audio_common_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    message-runtime \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/audio_common-release/archive/release/noetic/audio_common_msgs/0.3.18-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/audio_common_msgs"
SRC_URI = "git://github.com/ros-gbp/audio_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "34058e286668d83033b7b1b2354fa9696bd1aad4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
