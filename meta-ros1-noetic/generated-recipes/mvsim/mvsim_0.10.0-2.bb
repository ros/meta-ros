# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "A lightweight multivehicle simulation framework."
AUTHOR = "Jose-Luis Blanco-Claraco <jlblanco@ual.es>"
HOMEPAGE = "https://wiki.ros.org/mvsim"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mvsim"
ROS_BPN = "mvsim"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-venv} \
    boost \
    cv-bridge \
    dynamic-reconfigure \
    geometry-msgs \
    mrpt-libgui \
    mrpt-libmaps \
    mrpt-libposes \
    mrpt-libros-bridge \
    mrpt-libtclap \
    nav-msgs \
    protobuf \
    python3-pip \
    python3-protobuf \
    python3-pybind11 \
    ros-environment \
    roscpp \
    rviz-plugin-tutorials \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    tf2 \
    tf2-geometry-msgs \
    unzip \
    visualization-msgs \
    wget \
    zeromq \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-venv} \
    boost \
    cv-bridge \
    dynamic-reconfigure \
    geometry-msgs \
    mrpt-libgui \
    mrpt-libmaps \
    mrpt-libposes \
    mrpt-libros-bridge \
    mrpt-libtclap \
    nav-msgs \
    protobuf \
    python3-pip \
    python3-protobuf \
    python3-pybind11 \
    roscpp \
    rviz-plugin-tutorials \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    tf2 \
    tf2-geometry-msgs \
    unzip \
    visualization-msgs \
    wget \
    zeromq \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-python3-venv} \
    boost \
    cv-bridge \
    dynamic-reconfigure \
    geometry-msgs \
    mrpt-libgui \
    mrpt-libmaps \
    mrpt-libposes \
    mrpt-libros-bridge \
    mrpt-libtclap \
    nav-msgs \
    protobuf \
    python3-pip \
    python3-protobuf \
    python3-pybind11 \
    roscpp \
    rviz-plugin-tutorials \
    sensor-msgs \
    std-msgs \
    stereo-msgs \
    tf2 \
    tf2-geometry-msgs \
    unzip \
    visualization-msgs \
    wget \
    zeromq \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ual-arm-ros-pkg-release/mvsim-release/archive/release/noetic/mvsim/0.10.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/mvsim"
SRC_URI = "git://github.com/ual-arm-ros-pkg-release/mvsim-release;${ROS_BRANCH};protocol=https"
SRCREV = "b5bf50015bbe6a0c8cdebf8b80cc19962dd34208"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
