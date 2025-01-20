# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Scenario Execution for ROS"
AUTHOR = "Frederik Pasch <scenario-execution@intel.com>"
ROS_AUTHOR = "Frederik Pasch <scenario-execution@intel.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "scenario_execution"
ROS_BPN = "scenario_execution_ros"

ROS_BUILD_DEPENDS = " \
    scenario-execution \
"

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = " \
    scenario-execution \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-transforms3d} \
    py-trees \
    py-trees-ros \
    py-trees-ros-interfaces \
    rcl-interfaces \
    rclpy \
    scenario-execution \
    scenario-execution-py-trees-ros \
    visualization-msgs \
    xacro \
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

# matches with: https://github.com/ros2-gbp/scenario_execution-release/archive/release/humble/scenario_execution_ros/1.2.0-2.tar.gz
ROS_BRANCH ?= "branch=release/humble/scenario_execution_ros"
SRC_URI = "git://github.com/ros2-gbp/scenario_execution-release;${ROS_BRANCH};protocol=https"
SRCREV = "bde3cc436dfc818b32e7e47337af862a871f1ba8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
