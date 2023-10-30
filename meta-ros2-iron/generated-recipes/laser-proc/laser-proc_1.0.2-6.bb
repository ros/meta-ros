# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "laser_proc"
AUTHOR = "Chad Rockey <chadrockey@willowgarage.com>"
ROS_AUTHOR = "Chad Rockey <chadrockey@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/laser_proc"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "laser_proc"
ROS_BPN = "laser_proc"

ROS_BUILD_DEPENDS = " \
    class-loader \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    class-loader \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
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

# matches with: https://github.com/ros2-gbp/laser_proc-release/archive/release/iron/laser_proc/1.0.2-6.tar.gz
ROS_BRANCH ?= "branch=release/iron/laser_proc"
SRC_URI = "git://github.com/ros2-gbp/laser_proc-release;${ROS_BRANCH};protocol=https"
SRCREV = "07a74cc1f3d54f8c981b184ee260c33ef81fad64"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
