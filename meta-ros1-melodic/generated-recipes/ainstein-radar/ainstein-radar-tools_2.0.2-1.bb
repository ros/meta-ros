# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Tools for monitoring and validating radar data."
AUTHOR = "Nick Rotella <nick.rotella@ainstein.ai>"
ROS_AUTHOR = "Nick Rotella"
HOMEPAGE = "https://ainstein.ai/"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ainstein_radar"
ROS_BPN = "ainstein_radar_tools"

ROS_BUILD_DEPENDS = " \
    ainstein-radar-filters \
    ainstein-radar-msgs \
    cv-bridge \
    image-geometry \
    image-transport \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    vision-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ainstein-radar-filters \
    ainstein-radar-msgs \
    cv-bridge \
    image-geometry \
    image-transport \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    vision-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ainstein-radar-filters \
    ainstein-radar-msgs \
    cv-bridge \
    image-geometry \
    image-transport \
    pcl-ros \
    roscpp \
    sensor-msgs \
    std-msgs \
    vision-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/AinsteinAI/ainstein_radar-release/archive/release/melodic/ainstein_radar_tools/2.0.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/ainstein_radar_tools"
SRC_URI = "git://github.com/AinsteinAI/ainstein_radar-release;${ROS_BRANCH};protocol=https"
SRCREV = "1f03822768820f4efe77f6336fb79536cad718d7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
