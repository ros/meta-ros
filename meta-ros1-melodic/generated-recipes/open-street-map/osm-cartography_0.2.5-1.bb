# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Geographic mapping using Open Street Map data."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/osm_cartography"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "open_street_map"
ROS_BPN = "osm_cartography"

ROS_BUILD_DEPENDS = " \
    dynamic-reconfigure \
    geodesy \
    geographic-msgs \
    geometry-msgs \
    rospy \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    dynamic-reconfigure \
    geodesy \
    geographic-msgs \
    geometry-msgs \
    rospy \
    std-msgs \
    tf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    geodesy \
    geographic-msgs \
    geometry-msgs \
    rospy \
    route-network \
    std-msgs \
    tf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-geographic-info/open_street_map-release/archive/release/melodic/osm_cartography/0.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/osm_cartography"
SRC_URI = "git://github.com/ros-geographic-info/open_street_map-release;${ROS_BRANCH};protocol=https"
SRCREV = "a5c218d1f1b7e0c8a730e197cc60e8e1f4db9cfd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
