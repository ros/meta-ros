# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Package containing tools for monitoring ROS 2 topics."
AUTHOR = "Aditya Pande <aditya.pande@openrobotics.org>"
ROS_AUTHOR = "D. Hood"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "demos"
ROS_BPN = "topic_monitor"

ROS_BUILD_DEPENDS = " \
    rclpy \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    launch \
    launch-ros \
    rclpy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/demos-release/archive/release/jazzy/topic_monitor/0.33.5-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/topic_monitor"
SRC_URI = "git://github.com/ros2-gbp/demos-release;${ROS_BRANCH};protocol=https"
SRCREV = "33f1dde29a4a146bde0270c8bc347b4c67c0927b"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}