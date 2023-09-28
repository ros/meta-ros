# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Theora_image_transport provides a plugin to image_transport for     transparently sending an image stream encoded with the Theora codec."
AUTHOR = "Julius Kammerl <jkammerl@willowgarage.com>"
ROS_AUTHOR = "Patrick Mihelich"
HOMEPAGE = "http://www.ros.org/wiki/image_transport_plugins"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "image_transport_plugins"
ROS_BPN = "theora_image_transport"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    libogg \
    libtheora \
    message-generation \
    pluginlib \
    rosbag \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    libogg \
    libtheora \
    message-runtime \
    pluginlib \
    rosbag \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    libogg \
    libtheora \
    message-runtime \
    pluginlib \
    rosbag \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/image_transport_plugins-release/archive/release/melodic/theora_image_transport/1.9.5-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/theora_image_transport"
SRC_URI = "git://github.com/ros-gbp/image_transport_plugins-release;${ROS_BRANCH};protocol=https"
SRCREV = "ce1aaacf91a717ea76bf875cf27bd2486227b4ee"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
