# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Script to delay the launch of a roslaunch file"
AUTHOR = "Masaru Morita <p595201m@mail.kyutech.jp>"
ROS_AUTHOR = "Masaru Morita <p595201m@mail.kyutech.jp>"
HOMEPAGE = "https://github.com/MoriKen254/timed_roslaunch.git"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "timed_roslaunch"
ROS_BPN = "timed_roslaunch"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rospy \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/MoriKen254/timed_roslaunch-release/archive/release/melodic/timed_roslaunch/0.1.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/timed_roslaunch"
SRC_URI = "git://github.com/MoriKen254/timed_roslaunch-release;${ROS_BRANCH};protocol=https"
SRCREV = "9ee80603817b7038ceb9db2a5ba97bb3b948fee6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
