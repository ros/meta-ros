# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Compressed_image_transport provides a plugin to image_transport for transparently sending images     encoded as JPEG or PNG."
AUTHOR = "Kenji Brameld <kenjibrameld@gmail.com>"
ROS_AUTHOR = "Patrick Mihelich"
HOMEPAGE = "http://www.ros.org/wiki/image_transport_plugins"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "image_transport_plugins"
ROS_BPN = "compressed_image_transport"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    libjpeg-turbo \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    image-transport \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    libjpeg-turbo \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/image_transport_plugins-release/archive/release/noetic/compressed_image_transport/1.15.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/compressed_image_transport"
SRC_URI = "git://github.com/ros2-gbp/image_transport_plugins-release;${ROS_BRANCH};protocol=https"
SRCREV = "bfec705c916d1fa2721e7c7cacb2baac281df23e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
