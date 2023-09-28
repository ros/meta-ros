# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "HTTP Streaming of ROS Image Topics in Multiple Formats"
AUTHOR = "Russell Toris <rctoris@wpi.edu>"
ROS_AUTHOR = "Mitchell Wills <mwills@wpi.edu>"
HOMEPAGE = "http://ros.org/wiki/web_video_server"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "web_video_server"
ROS_BPN = "web_video_server"

ROS_BUILD_DEPENDS = " \
    async-web-server-cpp \
    cv-bridge \
    ffmpeg \
    image-transport \
    rclcpp \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    async-web-server-cpp \
    cv-bridge \
    ffmpeg \
    image-transport \
    rclcpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/web_video_server-release/archive/release/dashing/web_video_server/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/web_video_server"
SRC_URI = "git://github.com/ros2-gbp/web_video_server-release;${ROS_BRANCH};protocol=https"
SRCREV = "e09b55893dbaeac21c6a02d3c79f06d5a851ec4a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
