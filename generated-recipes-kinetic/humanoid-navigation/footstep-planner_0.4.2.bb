# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "<p>A footstep planner for humanoid / biped robots. The planner builds on SBPL and has anytime as well as dynamic replanning capabilities. The supported planners are: ARA*, AD*, R*.</p>     <p>Details can be found in the following publications:</p>     <p><em>&quot;Humanoid Navigation with Dynamic Footstep Plans&quot;</em>     by J. Garimort, A. Hornung, and M. Bennewitz; published in      Proc. of the IEEE International Conference on Robotics &amp; Automation (ICRA), 2011</p>     <p><em>Anytime Search-Based Footstep Planning with Suboptimality Bounds</em>     by A. Hornung, A. Dornbush, M. Likhachev, and M. Bennewitz; published in     Proc. of the IEEE-RAS International Conference on Humanoid     Robots (HUMANOIDS), 2012</p>"
AUTHOR = "Pramuditha Aravinda <aravindadp@gmail.com>"
ROS_AUTHOR = "Johannes Garimort"
HOMEPAGE = "http://wiki.ros.org/footstep_planner"
SECTION = "devel"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "humanoid_navigation"
ROS_BPN = "footstep_planner"

ROS_BUILD_DEPENDS = " \
    actionlib \
    angles \
    geometry-msgs \
    gridmap-2d \
    humanoid-nav-msgs \
    map-server \
    nav-msgs \
    opencv \
    rosconsole \
    roscpp \
    rospy \
    sbpl \
    sensor-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    angles \
    geometry-msgs \
    gridmap-2d \
    humanoid-nav-msgs \
    map-server \
    nav-msgs \
    opencv \
    rosconsole \
    roscpp \
    rospy \
    sbpl \
    sensor-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    angles \
    geometry-msgs \
    gridmap-2d \
    humanoid-nav-msgs \
    map-server \
    nav-msgs \
    opencv \
    rosconsole \
    roscpp \
    rospy \
    sbpl \
    sensor-msgs \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ROBOTIS-GIT-release/humanoid_navigation-release/archive/release/kinetic/footstep_planner/0.4.2-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c9be3c8f873409b7ca5ecbbe1943b878"
SRC_URI[sha256sum] = "065d2d1c76650b2d9afaf45a34017adcf54b604c0f33081b60380200f3cc427d"
S = "${WORKDIR}/humanoid_navigation-release-release-kinetic-footstep_planner-0.4.2-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('humanoid-navigation', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('humanoid-navigation', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/humanoid-navigation/humanoid-navigation_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/humanoid-navigation/humanoid-navigation-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/humanoid-navigation/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/humanoid-navigation/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
