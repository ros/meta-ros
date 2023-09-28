# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Node for the &quot;multivehicle simulator&quot; framework."
AUTHOR = "Jose-Luis Blanco-Claraco <jlblanco@ual.es>"
HOMEPAGE = "http://wiki.ros.org/mvsim"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "mvsim"
ROS_BPN = "mvsim"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    message-generation \
    message-runtime \
    mrpt-bridge \
    mrpt1 \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    message-generation \
    message-runtime \
    mrpt-bridge \
    mrpt1 \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    message-generation \
    message-runtime \
    mrpt-bridge \
    mrpt1 \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ual-arm-ros-pkg-release/mvsim-release/archive/release/melodic/mvsim/0.2.1-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/mvsim"
SRC_URI = "git://github.com/ual-arm-ros-pkg-release/mvsim-release;${ROS_BRANCH};protocol=https"
SRCREV = "825aa70c95213d7955d2dc6d4344ef5b73713486"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
