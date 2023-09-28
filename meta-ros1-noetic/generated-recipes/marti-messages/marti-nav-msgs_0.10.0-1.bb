# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "marti_nav_msgs"
AUTHOR = "Marc Alban <malban@swri.org>"
ROS_AUTHOR = "Marc Alban"
HOMEPAGE = "https://github.com/swri-robotics/marti_messages"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "marti_messages"
ROS_BPN = "marti_nav_msgs"

ROS_BUILD_DEPENDS = " \
    geographic-msgs \
    geometry-msgs \
    marti-common-msgs \
    message-generation \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geographic-msgs \
    geometry-msgs \
    marti-common-msgs \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geographic-msgs \
    geometry-msgs \
    marti-common-msgs \
    message-runtime \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/swri-robotics-gbp/marti_messages-release/archive/release/noetic/marti_nav_msgs/0.10.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/marti_nav_msgs"
SRC_URI = "git://github.com/swri-robotics-gbp/marti_messages-release;${ROS_BRANCH};protocol=https"
SRCREV = "4acfc2ad119d9d0ac57e7f8792fb90f4e9d0978d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
