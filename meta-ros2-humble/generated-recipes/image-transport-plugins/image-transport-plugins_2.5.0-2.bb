# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "A set of plugins for publishing and subscribing to sensor_msgs/Image topics     in representations other than raw pixel data. For example, for viewing a     stream of images off-robot, a video codec will give much lower bandwidth     and latency. For low frame rate tranport of high-definition images, you     might prefer sending them as JPEG or PNG-compressed form."
AUTHOR = "Michael Carroll <michael@openrobotics.org>"
ROS_AUTHOR = "Patrick Mihelich"
HOMEPAGE = "http://www.ros.org/wiki/image_transport_plugins"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "image_transport_plugins"
ROS_BPN = "image_transport_plugins"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    compressed-depth-image-transport \
    compressed-image-transport \
    theora-image-transport \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/image_transport_plugins-release/archive/release/humble/image_transport_plugins/2.5.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/image_transport_plugins"
SRC_URI = "git://github.com/ros2-gbp/image_transport_plugins-release;${ROS_BRANCH};protocol=https"
SRCREV = "9df1f3f26b186ad9e33136ceaa49c51091f3119c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
