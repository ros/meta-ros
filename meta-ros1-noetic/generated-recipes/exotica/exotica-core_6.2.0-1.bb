# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The Extensible Optimization Toolset (EXOTica) is a library for defining problems for robot motion planning."
AUTHOR = "Vladimir Ivan <v.ivan@ed.ac.uk>"
ROS_AUTHOR = "Yiming Yang"
HOMEPAGE = "https://github.com/ipab-slmc/exotica"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "exotica"
ROS_BPN = "exotica_core"

ROS_BUILD_DEPENDS = " \
    cmake-modules \
    eigen-conversions \
    geometry-msgs \
    kdl-parser \
    libtinyxml2 \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    msgpack-c \
    pluginlib \
    roscpp \
    std-msgs \
    tf \
    tf-conversions \
    zeromq \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    eigen-conversions \
    geometry-msgs \
    kdl-parser \
    libtinyxml2 \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    msgpack-c \
    orocos-kdl \
    pluginlib \
    roscpp \
    std-msgs \
    tf \
    tf-conversions \
    zeromq \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    eigen-conversions \
    geometry-msgs \
    kdl-parser \
    libtinyxml2 \
    moveit-core \
    moveit-msgs \
    moveit-ros-planning \
    msgpack-c \
    orocos-kdl \
    pluginlib \
    roscpp \
    std-msgs \
    tf \
    tf-conversions \
    zeromq \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipab-slmc/exotica-release/archive/release/noetic/exotica_core/6.2.0-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/exotica_core"
SRC_URI = "git://github.com/ipab-slmc/exotica-release;${ROS_BRANCH};protocol=https"
SRCREV = "32f20cd3bd40d5247bdc5c991cc41a96c1a2b52a"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
