# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "Messages for SocketCAN"
AUTHOR = "Josh Whitley <josh@electrifiedautonomy.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2_socketcan"
ROS_BPN = "ros2_socketcan_msgs"

ROS_BUILD_DEPENDS = " \
    rosidl-default-generators \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
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

# matches with: https://github.com/ros2-gbp/ros2_socketcan-release/archive/release/rolling/ros2_socketcan_msgs/1.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/ros2_socketcan_msgs"
SRC_URI = "git://github.com/ros2-gbp/ros2_socketcan-release;${ROS_BRANCH};protocol=https"
SRCREV = "181e851e78d05f6211aef8b74e106d09979bebbd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
