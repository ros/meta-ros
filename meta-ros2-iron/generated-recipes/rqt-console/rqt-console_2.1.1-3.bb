# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_iron
inherit ros_superflore_generated

DESCRIPTION = "rqt_console provides a GUI plugin for displaying and filtering ROS messages."
AUTHOR = "Dharini Dutia <dharini@openrobotics.org>"
ROS_AUTHOR = "Aaron Blasdel"
HOMEPAGE = "http://wiki.ros.org/rqt_console"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rqt_console"
ROS_BPN = "rqt_console"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ament-index-python \
    python-qt-binding \
    rcl-interfaces \
    rclpy \
    rqt-gui \
    rqt-gui-py \
    rqt-py-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rqt_console-release/archive/release/iron/rqt_console/2.1.1-3.tar.gz
ROS_BRANCH ?= "branch=release/iron/rqt_console"
SRC_URI = "git://github.com/ros2-gbp/rqt_console-release;${ROS_BRANCH};protocol=https"
SRCREV = "4b6881408e9d644a94539e2070c066f46d454337"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
