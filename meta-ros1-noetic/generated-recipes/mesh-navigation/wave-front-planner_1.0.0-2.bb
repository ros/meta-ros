# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The wave_front_planner package"
AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
ROS_AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD 3-Clause"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d84cded89c768806cb84461439476daa"

ROS_CN = "mesh_navigation"
ROS_BPN = "wave_front_planner"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    mbf-mesh-core \
    mbf-msgs \
    mbf-utility \
    mesh-map \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    mbf-mesh-core \
    mbf-msgs \
    mbf-utility \
    mesh-map \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    mbf-mesh-core \
    mbf-msgs \
    mbf-utility \
    mesh-map \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/uos-gbp/mesh_navigation-release/archive/release/noetic/wave_front_planner/1.0.0-2.tar.gz
ROS_BRANCH ?= "branch=release/noetic/wave_front_planner"
SRC_URI = "git://github.com/uos-gbp/mesh_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "83dd3868922e44504d8dd15f036de88f3178d84f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
