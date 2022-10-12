# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "The system_fingerprint package"
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD 2-clause"
LICENSE = "BSD-2-clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=34de8913993f99108716e847b8e8700e"

ROS_CN = "system_fingerprint"
ROS_BPN = "system_fingerprint"

ROS_BUILD_DEPENDS = " \
    rcl-interfaces \
    rclpy \
    ros2cli \
    ros2node \
    ros2param \
    ros2topic \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    rcl-interfaces \
    rclpy \
    ros2cli \
    ros2node \
    ros2param \
    ros2topic \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-git} \
    rcl-interfaces \
    rclpy \
    ros2cli \
    ros2node \
    ros2param \
    ros2topic \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/MetroRobots/ros_system_fingerprint-release/archive/release/humble/system_fingerprint/0.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/system_fingerprint"
SRC_URI = "git://github.com/MetroRobots/ros_system_fingerprint-release;${ROS_BRANCH};protocol=https"
SRCREV = "dfacec393b95ee4268656d7edea8917e484bbb2d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
