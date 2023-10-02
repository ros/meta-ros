# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "rqt_dep provides a GUI plugin for visualizing the ROS dependency graph."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
ROS_AUTHOR = "Thibault Kruse"
HOMEPAGE = "http://wiki.ros.org/rqt_dep"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_dep"
ROS_BPN = "rqt_dep"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-py-common \
    rqt-graph \
    rqt-gui-py \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-rospkg \
    python-qt-binding \
    qt-dotgraph \
    qt-gui \
    qt-gui-py-common \
    rqt-graph \
    rqt-gui-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ${PYTHON_PN}-mock \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rqt_dep-release/archive/release/melodic/rqt_dep/0.4.9-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rqt_dep"
SRC_URI = "git://github.com/ros-gbp/rqt_dep-release;${ROS_BRANCH};protocol=https"
SRCREV = "9d080666f50357aa9d98e5891eec5185de6a0161"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
