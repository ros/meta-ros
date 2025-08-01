# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Contains utility scripts that are meant to interact with the gazebo video monitor plugins."
AUTHOR = "Nick Lamprianidis <info@nlamprian.me>"
ROS_AUTHOR = "Nick Lamprianidis <info@nlamprian.me>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "gazebo_video_monitors"
ROS_BPN = "gazebo_video_monitor_utils"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-msgs \
    rclpy \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/gazebo_video_monitors-release/archive/release/humble/gazebo_video_monitor_utils/0.8.1-1.tar.gz
ROS_BRANCH ?= "branch=release/humble/gazebo_video_monitor_utils"
SRC_URI = "git://github.com/ros2-gbp/gazebo_video_monitors-release;${ROS_BRANCH};protocol=https"
SRCREV = "f49c6659093fa96e833c19c224461836e3017026"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
