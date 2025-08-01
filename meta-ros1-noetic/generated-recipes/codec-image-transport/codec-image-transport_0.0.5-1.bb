# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The codec_image_transport package"
AUTHOR = "Yoshito Okada <okada@rm.is.tohoku.ac.jp>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "codec_image_transport"
ROS_BPN = "codec_image_transport"

ROS_BUILD_DEPENDS = " \
    ffmpeg \
    image-transport \
    pluginlib \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ffmpeg \
    image-transport \
    pluginlib \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ffmpeg \
    image-transport \
    pluginlib \
    roscpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/yoshito-n-students/codec_image_transport-release/archive/release/noetic/codec_image_transport/0.0.5-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/codec_image_transport"
SRC_URI = "git://github.com/yoshito-n-students/codec_image_transport-release;${ROS_BRANCH};protocol=https"
SRCREV = "c7e7eac5e5dff8dab00251197f30fdb75af7f4d2"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
