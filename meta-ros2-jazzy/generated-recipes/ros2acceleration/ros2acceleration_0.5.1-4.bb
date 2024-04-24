# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "The acceleration command for ROS 2 command line tools."
AUTHOR = "Víctor Mayoral Vilches <victor@accelerationrobotics.com>"
ROS_AUTHOR = "Víctor Mayoral Vilches <victor@accelerationrobotics.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2acceleration"
ROS_BPN = "ros2acceleration"

ROS_BUILD_DEPENDS = " \
    ros2cli \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ros2cli \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    python3-numpy \
    python3-pyyaml \
    rclpy \
    ros2cli \
    rosidl-runtime-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    ament-xmllint \
    python3-pytest \
    test-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2acceleration-release/archive/release/jazzy/ros2acceleration/0.5.1-4.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/ros2acceleration"
SRC_URI = "git://github.com/ros2-gbp/ros2acceleration-release;${ROS_BRANCH};protocol=https"
SRCREV = "18eede7c818416a07f43314c8a39b6c7abc5b03e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
