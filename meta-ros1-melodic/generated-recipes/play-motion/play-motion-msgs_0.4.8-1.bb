# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Messages, services and actions used by play_motion."
AUTHOR = "Adolfo Rodriguez Tsouroukdissian <adolfo.rodriguez@pal-robotics.com>"
ROS_AUTHOR = "Paul Mathieu <paul.mathieu@pal-robotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "play_motion"
ROS_BPN = "play_motion_msgs"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    message-generation \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
    message-runtime \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    message-runtime \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pal-gbp/play_motion-release2/archive/release/melodic/play_motion_msgs/0.4.8-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/play_motion_msgs"
SRC_URI = "git://github.com/pal-gbp/play_motion-release2;${ROS_BRANCH};protocol=https"
SRCREV = "6112aebf0597c256810496d12cd9617cee667e8b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
