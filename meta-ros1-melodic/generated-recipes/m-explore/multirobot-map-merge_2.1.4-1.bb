# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Merging multiple maps without knowledge of initial   positions of robots."
AUTHOR = "Jiri Horner <laeqten@gmail.com>"
ROS_AUTHOR = "Jiri Horner <laeqten@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/multirobot_map_merge"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "m_explore"
ROS_BPN = "multirobot_map_merge"

ROS_BUILD_DEPENDS = " \
    geometry-msgs \
    image-geometry \
    map-msgs \
    nav-msgs \
    roscpp \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geometry-msgs \
    image-geometry \
    map-msgs \
    nav-msgs \
    roscpp \
    tf2-geometry-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    image-geometry \
    map-msgs \
    nav-msgs \
    roscpp \
    tf2-geometry-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/hrnr/m-explore-release/archive/release/melodic/multirobot_map_merge/2.1.4-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/multirobot_map_merge"
SRC_URI = "git://github.com/hrnr/m-explore-release;${ROS_BRANCH};protocol=https"
SRCREV = "f7dc3e43f68d91f0888201050859eaed89a57efd"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
