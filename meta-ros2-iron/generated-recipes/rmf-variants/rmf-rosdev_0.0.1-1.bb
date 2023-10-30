# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "A package to aggregate the packages required for a minimal installation of Open-RMF"
AUTHOR = "Yadunund <yadunund@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmf_variants"
ROS_BPN = "rmf_dev"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-cmake-catch2 \
    menge-vendor \
    nlohmann-json-schema-validator-vendor \
    pybind11-json-vendor \
    rmf-api-msgs \
    rmf-battery \
    rmf-building-map-msgs \
    rmf-building-map-tools \
    rmf-building-sim-common \
    rmf-building-sim-gz-classic-plugins \
    rmf-building-sim-gz-plugins \
    rmf-charger-msgs \
    rmf-dispenser-msgs \
    rmf-door-msgs \
    rmf-fleet-adapter \
    rmf-fleet-adapter-python \
    rmf-fleet-msgs \
    rmf-ingestor-msgs \
    rmf-lift-msgs \
    rmf-obstacle-msgs \
    rmf-robot-sim-common \
    rmf-robot-sim-gz-classic-plugins \
    rmf-robot-sim-gz-plugins \
    rmf-scheduler-msgs \
    rmf-site-map-msgs \
    rmf-task \
    rmf-task-msgs \
    rmf-task-ros2 \
    rmf-task-sequence \
    rmf-traffic \
    rmf-traffic-editor \
    rmf-traffic-editor-assets \
    rmf-traffic-editor-test-maps \
    rmf-traffic-examples \
    rmf-traffic-msgs \
    rmf-traffic-ros2 \
    rmf-utils \
    rmf-visualization \
    rmf-visualization-building-systems \
    rmf-visualization-fleet-states \
    rmf-visualization-floorplans \
    rmf-visualization-msgs \
    rmf-visualization-navgraphs \
    rmf-visualization-obstacles \
    rmf-visualization-rviz2-plugins \
    rmf-visualization-schedule \
    rmf-websocket \
    rmf-workcell-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmf_variants-release/archive/release/iron/rmf_dev/0.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/iron/rmf_dev"
SRC_URI = "git://github.com/ros2-gbp/rmf_variants-release;${ROS_BRANCH};protocol=https"
SRCREV = "d520e9944ea63e0e1e204084218763df397e9520"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
