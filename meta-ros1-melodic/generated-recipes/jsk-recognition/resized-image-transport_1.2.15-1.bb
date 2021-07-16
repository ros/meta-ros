# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS nodes to publish resized images."
AUTHOR = "Yohei Kakiuchi <youhei@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Yohei Kakiuchi <youhei@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "https://jsk-docs.readthedocs.io/projects/jsk_recognition/en/latest/resized_image_transport"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_recognition"
ROS_BPN = "resized_image_transport"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    image-transport \
    jsk-topic-tools \
    message-generation \
    nodelet \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    image-transport \
    jsk-topic-tools \
    message-runtime \
    nodelet \
    sensor-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    image-transport \
    jsk-topic-tools \
    message-runtime \
    nodelet \
    sensor-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    jsk-recognition-utils \
    jsk-tools \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_recognition-release/archive/release/melodic/resized_image_transport/1.2.15-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/resized_image_transport"
SRC_URI = "git://github.com/tork-a/jsk_recognition-release;${ROS_BRANCH};protocol=https"
SRCREV = "628613a4eb71957589c4af551a32cdc2e7b9ad66"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
