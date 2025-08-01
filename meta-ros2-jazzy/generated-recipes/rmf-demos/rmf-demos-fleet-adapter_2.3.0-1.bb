# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_jazzy
inherit ros_superflore_generated

DESCRIPTION = "Fleet adapters for interfacing with RMF Demos robots with a fleet manager via REST API"
AUTHOR = "Xi Yu Oh <xiyu@openrobotics.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmf_demos"
ROS_BPN = "rmf_demos_fleet_adapter"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-fastapi} \
    ${ROS_UNRESOLVED_DEP-python3-uvicorn} \
    launch-xml \
    python3-flask-socketio \
    python3-numpy \
    python3-pydantic \
    python3-pyproj \
    python3-pyyaml \
    python3-requests \
    rclpy \
    rmf-fleet-adapter-python \
    rmf-fleet-msgs \
    rmf-task-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmf_demos-release/archive/release/jazzy/rmf_demos_fleet_adapter/2.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/jazzy/rmf_demos_fleet_adapter"
SRC_URI = "git://github.com/ros2-gbp/rmf_demos-release;${ROS_BRANCH};protocol=https"
SRCREV = "f65aab80fe6bac40c7683cce6ab42d2fabb7a875"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
