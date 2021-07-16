# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Filters the robot's body out of point clouds."
AUTHOR = "David Feil-Seifer <dave@cse.unr.edu>"
ROS_AUTHOR = "Eitan Marder-Eppstein"
HOMEPAGE = "http://ros.org/wiki/pr2_navigation_self_filter"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_navigation"
ROS_BPN = "pr2_navigation_self_filter"

ROS_BUILD_DEPENDS = " \
    assimp \
    bullet \
    filters \
    pcl-ros \
    resource-retriever \
    roscpp \
    sensor-msgs \
    tf \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    bullet \
    filters \
    pcl-ros \
    resource-retriever \
    roscpp \
    sensor-msgs \
    tf \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    bullet \
    filters \
    pcl-ros \
    resource-retriever \
    roscpp \
    sensor-msgs \
    tf \
    urdf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_navigation-release/archive/release/melodic/pr2_navigation_self_filter/0.1.28-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pr2_navigation_self_filter"
SRC_URI = "git://github.com/pr2-gbp/pr2_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "730d22960fcff5927e7dda736696a147b72b4907"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
