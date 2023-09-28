# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "rqt_tf_tree provides a GUI plugin for visualizing the ROS TF frame tree."
AUTHOR = "Isaac I.Y. Saito <gm130s@gmail.com>"
ROS_AUTHOR = "Thibault Kruse"
HOMEPAGE = "http://wiki.ros.org/rqt_tf_tree"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_tf_tree"
ROS_BPN = "rqt_tf_tree"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    python-qt-binding \
    qt-dotgraph \
    rclpy \
    rqt-graph \
    rqt-gui \
    rqt-gui-py \
    tf2-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    python3-mock \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rqt_tf_tree-release/archive/release/eloquent/rqt_tf_tree/1.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/rqt_tf_tree"
SRC_URI = "git://github.com/ros2-gbp/rqt_tf_tree-release;${ROS_BRANCH};protocol=https"
SRCREV = "386598bdfca62fd42ae63c2a7dc058f5173c8726"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
