# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "RVIZ plugin for IMU visualization"
AUTHOR = "Martin Günther <martin.guenther1980@gmail.com>"
ROS_AUTHOR = "Ivan Dryanovski <ivan.dryanovski@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/rviz_imu_plugin"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "imu_tools"
ROS_BPN = "rviz_imu_plugin"

ROS_BUILD_DEPENDS = " \
    qtbase \
    roscpp \
    rviz \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    qtbase \
    roscpp \
    rviz \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    qtbase \
    roscpp \
    rviz \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/uos-gbp/imu_tools-release/archive/release/noetic/rviz_imu_plugin/1.2.3-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/rviz_imu_plugin"
SRC_URI = "git://github.com/uos-gbp/imu_tools-release;${ROS_BRANCH};protocol=https"
SRCREV = "52ed588cb199b153d3c8c7e7821dd8e73599c8b3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
