# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "System modes specific extensions to the launch tool, i.e. launch actions, events, and event     handlers for system modes."
AUTHOR = "Arne Nordmann <arne.nordmann@de.bosch.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "system_modes"
ROS_BPN = "launch_system_modes"

ROS_BUILD_DEPENDS = " \
    ament-index-python \
    launch \
    osrf-pycommon \
    python3-importlib-metadata \
    python3-pyyaml \
    rclpy \
    system-modes-msgs \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    ament-index-python \
    launch \
    osrf-pycommon \
    python3-importlib-metadata \
    python3-pyyaml \
    rclpy \
    system-modes-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    launch \
    osrf-pycommon \
    python3-importlib-metadata \
    python3-pyyaml \
    rclpy \
    system-modes-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/system_modes-release/archive/release/galactic/launch_system_modes/0.8.0-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/launch_system_modes"
SRC_URI = "git://github.com/ros2-gbp/system_modes-release;${ROS_BRANCH};protocol=https"
SRCREV = "6102a950599fc89cbcdfd6294af45c386a2cc924"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
