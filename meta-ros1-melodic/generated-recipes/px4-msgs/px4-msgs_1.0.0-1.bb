# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Package with the ROS-equivalent of PX4 uORB msgs"
AUTHOR = "Nuno Marques <nuno.marques@dronesolutions.io>"
ROS_AUTHOR = "Nuno Marques <nuno.marques@dronesolutions.io>"
HOMEPAGE = "https://github.com/PX4/px4_msgs.git"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f5654d47d02d927c4f7a04f0a51abaa1"

ROS_CN = "px4_msgs"
ROS_BPN = "px4_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
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

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/PX4/px4_msgs-release/archive/release/melodic/px4_msgs/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/px4_msgs"
SRC_URI = "git://github.com/PX4/px4_msgs-release;${ROS_BRANCH};protocol=https"
SRCREV = "abc9c49796b560624eb4cc0488356d5877e3d39d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
