# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "qt_gui_py_common provides common functionality for GUI plugins written in Python."
AUTHOR = "Dorian Scholz <scholz@sim.tu-darmstadt.de>"
ROS_AUTHOR = "Dorian Scholz"
HOMEPAGE = "http://ros.org/wiki/qt_gui_py_common"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "qt_gui_core"
ROS_BPN = "qt_gui_py_common"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    python-qt-binding \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/qt_gui_core-release/archive/release/rolling/qt_gui_py_common/2.8.2-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/qt_gui_py_common"
SRC_URI = "git://github.com/ros2-gbp/qt_gui_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "f44c96e1a0306fc3c9e68adb9d86020aebf17f83"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
