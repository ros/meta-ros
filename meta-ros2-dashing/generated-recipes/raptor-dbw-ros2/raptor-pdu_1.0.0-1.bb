# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "Interface for the New Eagle Multiplex Power Distribution Module (MPDM)     https://store.neweagle.net/product/multiplexed-power-distribution-module-mpdm/"
AUTHOR = "New Eagle <neweagleraptorgithub@neweagle.net>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "raptor_dbw_ros2"
ROS_BPN = "raptor_pdu"

ROS_BUILD_DEPENDS = " \
    can-msgs \
    raptor-can-dbc-parser \
    raptor-pdu-msgs \
    rclcpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    can-msgs \
    raptor-can-dbc-parser \
    raptor-pdu-msgs \
    rclcpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    can-msgs \
    raptor-can-dbc-parser \
    raptor-pdu-msgs \
    rclcpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/NewEagleRaptor/raptor-dbw-ros2-release/archive/release/dashing/raptor_pdu/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/raptor_pdu"
SRC_URI = "git://github.com/NewEagleRaptor/raptor-dbw-ros2-release;${ROS_BRANCH};protocol=https"
SRCREV = "d42d0d81c62b93911e92d3b52e187c9d3f2c9166"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
