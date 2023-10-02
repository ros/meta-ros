# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "Msg and srv definitions for rc_reason_clients"
AUTHOR = "Felix Ruess <felix.ruess@roboception.de>"
HOMEPAGE = "https://github.com/roboception/rc_reason_clients_ros"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rc_reason_clients"
ROS_BPN = "rc_reason_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    message-generation \
    rc-common-msgs \
    shape-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    rc-common-msgs \
    shape-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    message-runtime \
    rc-common-msgs \
    shape-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/roboception-gbp/rc_reason_clients_ros-release/archive/release/noetic/rc_reason_msgs/0.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rc_reason_msgs"
SRC_URI = "git://github.com/roboception-gbp/rc_reason_clients_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "4f2e03c8d12dc65804dc566f6aa8ce1ca8d13ebe"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
