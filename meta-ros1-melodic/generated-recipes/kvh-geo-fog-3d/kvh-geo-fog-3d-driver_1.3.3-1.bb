# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "A ROS driver for the KVH Geo Fog 3D INS family of systems."
AUTHOR = "Zach LaCelle <zlacelle@mitre.org>"
ROS_AUTHOR = "Trevor Bostic <tbostic@mitre.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "kvh_geo_fog_3d"
ROS_BPN = "kvh_geo_fog_3d_driver"

ROS_BUILD_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    kvh-geo-fog-3d-msgs \
    message-generation \
    nav-msgs \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    diagnostic-updater \
    dynamic-reconfigure \
    geometry-msgs \
    kvh-geo-fog-3d-msgs \
    message-generation \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    dynamic-reconfigure \
    geometry-msgs \
    kvh-geo-fog-3d-msgs \
    message-runtime \
    nav-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
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

# matches with: https://github.com/MITRE/kvh_geo_fog_3d-release/archive/release/melodic/kvh_geo_fog_3d_driver/1.3.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/kvh_geo_fog_3d_driver"
SRC_URI = "git://github.com/MITRE/kvh_geo_fog_3d-release;${ROS_BRANCH};protocol=https"
SRCREV = "16b3aa89a1296ec25f0cd251bd3a156b4064349e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
