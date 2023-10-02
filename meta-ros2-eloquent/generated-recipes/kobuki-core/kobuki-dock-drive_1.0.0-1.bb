# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_eloquent
inherit ros_superflore_generated

DESCRIPTION = "Dock driving library for Kobuki. Users owning a docking station for Kobuki 	    can use this tool to develop autonomous docking drive algorithms."
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Daniel Stonier"
HOMEPAGE = "https://index.ros.org/k/kobuki_dock_drive/github-kobuki-base-kobuki_dock_drive"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "kobuki_core"
ROS_BPN = "kobuki_dock_drive"

ROS_BUILD_DEPENDS = " \
    ecl-build \
    ecl-geometry \
    ecl-linear-algebra \
    ecl-threads \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ecl-geometry \
    ecl-linear-algebra \
    ecl-threads \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/stonier/kobuki_core-release/archive/release/eloquent/kobuki_dock_drive/1.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/eloquent/kobuki_dock_drive"
SRC_URI = "git://github.com/stonier/kobuki_core-release;${ROS_BRANCH};protocol=https"
SRCREV = "6797b261fb861f681d70e0f897f7691cf163bd87"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
