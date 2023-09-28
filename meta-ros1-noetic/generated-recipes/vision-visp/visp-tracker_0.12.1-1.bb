# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Wraps the ViSP moving edge tracker provided by the ViSP visual     servoing library into a ROS package.      This computer vision algorithm computes the pose (i.e. position     and orientation) of an object in an image. It is fast enough to     allow object online tracking using a camera."
AUTHOR = "Fabien Spindler <fabien.spindler@inria.fr>"
ROS_AUTHOR = "Thomas Moulard <thomas.moulard@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/wiki/visp_tracker"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "vision_visp"
ROS_BPN = "visp_tracker"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    geometry-msgs \
    image-proc \
    image-transport \
    message-generation \
    nodelet \
    resource-retriever \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    tf \
    visp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    geometry-msgs \
    image-proc \
    image-transport \
    message-generation \
    message-runtime \
    nodelet \
    resource-retriever \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    tf \
    visp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    geometry-msgs \
    image-proc \
    image-transport \
    message-generation \
    message-runtime \
    nodelet \
    resource-retriever \
    roscpp \
    rospy \
    sensor-msgs \
    std-msgs \
    tf \
    visp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/lagadic/vision_visp-release/archive/release/noetic/visp_tracker/0.12.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/visp_tracker"
SRC_URI = "git://github.com/lagadic/vision_visp-release;${ROS_BRANCH};protocol=https"
SRCREV = "102e7987ca47450efdfb01f7f3375a6992d11822"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
