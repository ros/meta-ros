# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Messages definitions for representing computer's hardware state, such as battery information, GPU, some miscellaneous sensors. Format is in ROS. Originally developed at <a href="https://github.com/PR2/pr2_common/tree/e64f0362b7bff0f4d1d9916f805cf91ad561b439/pr2_msgs">pr2_common repository</a>"
AUTHOR = "Isaac I.Y. Saito <130s@2000.jukuin.keio.ac.jp>"
ROS_AUTHOR = "Eric Berger and many others"
HOMEPAGE = "http://ros.org/wiki/computer_status_msgs"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "computer_status_msgs"
ROS_BPN = "computer_status_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-generation \
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

# matches with: https://github.com/kinu-garage/computer_status_msgs-release/archive/release/noetic/computer_status_msgs/2.1.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/computer_status_msgs"
SRC_URI = "git://github.com/kinu-garage/computer_status_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "ab2645d138a04808ced8416e1fddf3c29bcd0c0e"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
