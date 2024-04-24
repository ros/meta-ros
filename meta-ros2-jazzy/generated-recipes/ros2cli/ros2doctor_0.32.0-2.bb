# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "A command line tool to check potential issues in a ROS 2 system"
AUTHOR = "Audrow Nash <audrow@openrobotics.org>"
ROS_AUTHOR = "Aditya Pande <aditya.pande@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ros2cli"
ROS_BPN = "ros2doctor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    python3-catkin-pkg \
    python3-importlib-metadata \
    python3-psutil \
    python3-rosdistro \
    rclpy \
    ros-environment \
    ros2cli \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    ament-xmllint \
    launch \
    launch-ros \
    launch-testing \
    launch-testing-ros \
    python3-pytest \
    python3-pytest-timeout \
    std-msgs \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/ros2cli-release/archive/release/jazzy/ros2doctor/0.32.0-2.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/ros2doctor"
SRC_URI = "git://github.com/ros2-gbp/ros2cli-release;${ROS_BRANCH};protocol=https"
SRCREV = "069af4ec2fc2f853776a3e67adb9259315e698cf"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
