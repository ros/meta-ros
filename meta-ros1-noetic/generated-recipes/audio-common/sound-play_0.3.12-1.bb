# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "sound_play provides a ROS node that translates commands on a ROS topic (<tt>robotsound</tt>) into sounds. The node supports built-in sounds, playing OGG/WAV files, and doing speech synthesis via festival. C++ and Python bindings allow this node to be used without understanding the details of the message format, allowing faster development and resilience to message format changes."
AUTHOR = "Austin Hendrix <namniart@gmail.com>"
ROS_AUTHOR = "Blaise Gassend"
HOMEPAGE = "http://ros.org/wiki/sound_play"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

ROS_CN = "audio_common"
ROS_BPN = "sound_play"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    audio-common-msgs \
    diagnostic-msgs \
    message-generation \
    roscpp \
    roslib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    python3-setuptools-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    audio-common-msgs \
    diagnostic-msgs \
    festival \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    message-runtime \
    python3-pygobject \
    roscpp \
    roslib \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/audio_common-release/archive/release/noetic/sound_play/0.3.12-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/sound_play"
SRC_URI = "git://github.com/ros-gbp/audio_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "de92c602b3cd2b484ab854f9f3f5950195a63d87"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
