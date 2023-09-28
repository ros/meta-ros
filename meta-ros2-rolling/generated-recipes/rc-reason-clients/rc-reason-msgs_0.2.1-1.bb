# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Msg and srv definitions for rc_reason_clients"
AUTHOR = "Felix Ruess <felix.ruess@roboception.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rc_reason_clients"
ROS_BPN = "rc_reason_msgs"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    rc-common-msgs \
    shape-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
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
    rc-common-msgs \
    rosidl-default-runtime \
    shape-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/roboception-gbp/rc_reason_clients-release/archive/release/rolling/rc_reason_msgs/0.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/rc_reason_msgs"
SRC_URI = "git://github.com/roboception-gbp/rc_reason_clients-release;${ROS_BRANCH};protocol=https"
SRCREV = "9fcfca97ca76447881d700307378462922704f4c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
