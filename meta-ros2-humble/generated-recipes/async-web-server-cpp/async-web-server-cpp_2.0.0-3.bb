# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Asynchronous Web/WebSocket Server in C++"
AUTHOR = "Timo Röhling <timo.roehling@fkie.fraunhofer.de>"
ROS_AUTHOR = "Mitchell Wills <mwills@wpi.edu>"
HOMEPAGE = "http://ros.org/wiki/async_web_server_cpp"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "async_web_server_cpp"
ROS_BPN = "async_web_server_cpp"

ROS_BUILD_DEPENDS = " \
    boost \
    openssl \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    launch-testing \
    python3-websocket-client \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/async_web_server_cpp-release/archive/release/humble/async_web_server_cpp/2.0.0-3.tar.gz
ROS_BRANCH ?= "branch=release/humble/async_web_server_cpp"
SRC_URI = "git://github.com/ros2-gbp/async_web_server_cpp-release;${ROS_BRANCH};protocol=https"
SRCREV = "da6bf2dfe2ff62bb07c2052033dad73cdd59b3e0"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
