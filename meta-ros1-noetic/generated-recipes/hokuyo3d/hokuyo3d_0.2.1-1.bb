# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "ROS driver node for HOKUYO 3D LIDARs"
AUTHOR = "Atsushi Watanabe <atsushi.w@ieee.org>"
ROS_AUTHOR = "Atsushi Watanabe <atsushi.w@ieee.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "hokuyo3d"
ROS_BPN = "hokuyo3d"

ROS_BUILD_DEPENDS = " \
    roscpp \
    roslint \
    rostest \
    sensor-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    sensor-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    sensor-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/at-wat/hokuyo3d-release/archive/release/noetic/hokuyo3d/0.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/hokuyo3d"
SRC_URI = "git://github.com/at-wat/hokuyo3d-release;${ROS_BRANCH};protocol=https"
SRCREV = "729c5274cec7ee10b5afb86ab2b2bfa17875138a"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
